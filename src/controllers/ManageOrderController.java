package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Medicine;
import util.DatabaseConnection;

public class ManageOrderController {

    public List<Medicine> searchMedicines(String searchText) {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE name LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("medicineId"));
                m.setName(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setStockQuantity(rs.getInt("stockQuantity"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean placeOrder(int medicineId, int quantity) {
        String customerId = "CU001";
        String orderId = "O" + System.currentTimeMillis();
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            String checkSql = "SELECT price, stockQuantity FROM Medicine WHERE medicineId = ?";
            try (PreparedStatement checkPs = conn.prepareStatement(checkSql)) {
                checkPs.setInt(1, medicineId);
                ResultSet rs = checkPs.executeQuery();
                if (!rs.next()) {
                    conn.rollback();
                    return false;
                }
                double price = rs.getDouble("price");
                int stock = rs.getInt("stockQuantity");
                if (stock < quantity) {
                    conn.rollback();
                    return false;
                }
                double total = price * quantity;
                String insertOrder = "INSERT INTO OrderTable (orderId, customerId, totalAmount, status, deliveryAddress) VALUES (?, ?, ?, 'Pending', 'Default Address')";
                try (PreparedStatement ps = conn.prepareStatement(insertOrder)) {
                    ps.setString(1, orderId);
                    ps.setString(2, customerId);
                    ps.setDouble(3, total);
                    ps.executeUpdate();
                }
                String insertItem = "INSERT INTO OrderItem (orderId, medicineId, quantity, price) VALUES (?, ?, ?, ?)";
                try (PreparedStatement psItem = conn.prepareStatement(insertItem)) {
                    psItem.setString(1, orderId);
                    psItem.setInt(2, medicineId);
                    psItem.setInt(3, quantity);
                    psItem.setDouble(4, price);
                    psItem.executeUpdate();
                }
                String updateStock = "UPDATE Medicine SET stockQuantity = ? WHERE medicineId = ?";
                try (PreparedStatement updatePs = conn.prepareStatement(updateStock)) {
                    updatePs.setInt(1, stock - quantity);
                    updatePs.setInt(2, medicineId);
                    updatePs.executeUpdate();
                }
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancelOrder(String orderId) {
        String sql = "UPDATE OrderTable SET status = 'Cancelled' WHERE orderId = ? AND status = 'Pending'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, orderId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyOrder(String orderId, int newQty) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            String checkSql = "SELECT oi.medicineId, oi.quantity, m.price, m.stockQuantity " +
                             "FROM OrderTable ot " +
                             "JOIN OrderItem oi ON ot.orderId = oi.orderId " +
                             "JOIN Medicine m ON oi.medicineId = m.medicineId " +
                             "WHERE ot.orderId = ? AND ot.status = 'Pending'";
            try (PreparedStatement checkPs = conn.prepareStatement(checkSql)) {
                checkPs.setString(1, orderId);
                ResultSet rs = checkPs.executeQuery();
                if (!rs.next()) {
                    conn.rollback();
                    return false;
                }
                int medicineId = rs.getInt("medicineId");
                double price = rs.getDouble("price");
                int oldQty = rs.getInt("quantity");
                int currentStock = rs.getInt("stockQuantity");
                int stockDiff = newQty - oldQty;
                if (currentStock < stockDiff) {
                    conn.rollback();
                    return false;
                }
                double newTotal = price * newQty;
                String updateOrder = "UPDATE OrderTable SET totalAmount = ? WHERE orderId = ?";
                try (PreparedStatement ps = conn.prepareStatement(updateOrder)) {
                    ps.setDouble(1, newTotal);
                    ps.setString(2, orderId);
                    ps.executeUpdate();
                }
                String updateItem = "UPDATE OrderItem SET quantity = ? WHERE orderId = ?";
                try (PreparedStatement psItem = conn.prepareStatement(updateItem)) {
                    psItem.setInt(1, newQty);
                    psItem.setString(2, orderId);
                    psItem.executeUpdate();
                }
                String updateStock = "UPDATE Medicine SET stockQuantity = ? WHERE medicineId = ?";
                try (PreparedStatement psStock = conn.prepareStatement(updateStock)) {
                    psStock.setInt(1, currentStock - stockDiff);
                    psStock.setInt(2, medicineId);
                    psStock.executeUpdate();
                }
                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
