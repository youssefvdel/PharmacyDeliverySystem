package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Medicine;
import model.Order;
import util.DatabaseConnection;

public class ManageOrderController {

    public List<Medicine> searchMedicines(String query) {
        List<Medicine> medicines = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE name LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + query + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("medicineId"));
                m.setName(rs.getString("name"));
                m.setCategory(rs.getString("category"));
                m.setPrice(rs.getDouble("price"));
                m.setStockQuantity(rs.getInt("stockQuantity"));
                m.setExpiryDate(rs.getString("expiryDate"));
                medicines.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medicines;
    }

    public boolean placeOrder(int medicineId, int quantity) {
        String orderId = "O" + System.currentTimeMillis();
        String customerId = "CU001";
        String insertOrder = "INSERT INTO OrderTable (orderId, customerId, status, deliveryAddress, totalAmount) VALUES (?, ?, 'Pending', 'Default Address', 0.0)";
        String insertItem = "INSERT INTO OrderItem (orderId, medicineId, quantity, price) VALUES (?, ?, ?, (SELECT price FROM Medicine WHERE medicineId = ?))";
        String updateStock = "UPDATE Medicine SET stockQuantity = stockQuantity - ? WHERE medicineId = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(insertOrder)) {
                ps1.setString(1, orderId);
                ps1.setString(2, customerId);
                ps1.executeUpdate();
            }

            try (PreparedStatement ps2 = conn.prepareStatement(insertItem)) {
                ps2.setString(1, orderId);
                ps2.setInt(2, medicineId);
                ps2.setInt(3, quantity);
                ps2.setInt(4, medicineId);
                ps2.executeUpdate();
            }

            try (PreparedStatement ps3 = conn.prepareStatement(updateStock)) {
                ps3.setInt(1, quantity);
                ps3.setInt(2, medicineId);
                ps3.executeUpdate();
            }

            conn.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean cancelOrder(String orderId) {
        String sql = "UPDATE OrderTable SET status='Cancelled' WHERE orderId=? AND status='Pending'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, orderId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
