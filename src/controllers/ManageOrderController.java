package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Medicine;
import util.DatabaseConnection;

public class ManageOrderController {

    // Search medicines
    public List<Medicine> searchMedicines(String searchText) {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM APP.MEDICINE WHERE NAME LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + searchText + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("MEDICINEID"));      // UPPERCASE for Derby
                m.setName(rs.getString("NAME"));
                m.setPrice(rs.getDouble("PRICE"));
                m.setStockQuantity(rs.getInt("STOCKQUANTITY"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //  Place order
    public boolean placeOrder(int medicineId, int quantity) {
        String customerId = "CUST001"; 
        String orderId = "O" + System.currentTimeMillis();
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            
            // 1. Get medicine price and check stock
            String checkSql = "SELECT PRICE, STOCKQUANTITY FROM APP.MEDICINE WHERE MEDICINEID = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, medicineId);
            ResultSet rs = checkPs.executeQuery();
            
            if (!rs.next()) {
                conn.rollback();
                return false; // Medicine not found
            }
            
            double price = rs.getDouble("PRICE");
            int stock = rs.getInt("STOCKQUANTITY");
            
            if (stock < quantity) {
                conn.rollback();
                return false; // Insufficient stock
            }
            
            double total = price * quantity;
            
            // 2. Insert order
            String insertOrder = "INSERT INTO APP.ORDERTABLE (ORDERID, CUSTOMERID, TOTALAMOUNT, STATUS) VALUES (?, ?, ?, 'PENDING')";
            PreparedStatement ps = conn.prepareStatement(insertOrder);
            ps.setString(1, orderId);
            ps.setString(2, customerId);
            ps.setDouble(3, total);
            ps.executeUpdate();
            
            // 3. Update stock
            String updateStock = "UPDATE APP.MEDICINE SET STOCKQUANTITY = ? WHERE MEDICINEID = ?";
            PreparedStatement updatePs = conn.prepareStatement(updateStock);
            updatePs.setInt(1, stock - quantity);
            updatePs.setInt(2, medicineId);
            updatePs.executeUpdate();
            
            conn.commit();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cancel order
    public boolean cancelOrder(String orderId) {
        String sql = "UPDATE APP.ORDERTABLE SET STATUS = 'CANCELLED' WHERE ORDERID = ? AND STATUS = 'PENDING'";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, orderId);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Modify order
    public boolean modifyOrder(String orderId, int newQty) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            
            // 1. Check if order is pending and get current medicine
            String checkSql = "SELECT OT.*, OI.MEDICINEID, M.PRICE, M.STOCKQUANTITY " +
                             "FROM APP.ORDERTABLE OT " +
                             "JOIN APP.ORDERITEM OI ON OT.ORDERID = OI.ORDERID " +
                             "JOIN APP.MEDICINE M ON OI.MEDICINEID = M.MEDICINEID " +
                             "WHERE OT.ORDERID = ? AND OT.STATUS = 'PENDING'";
            
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setString(1, orderId);
            ResultSet rs = checkPs.executeQuery();
            
            if (!rs.next()) {
                return false; // Order not found or not pending
            }
            
            int medicineId = rs.getInt("MEDICINEID");
            double price = rs.getDouble("PRICE");
            int oldQty = rs.getInt("QUANTITY"); 
            int currentStock = rs.getInt("STOCKQUANTITY");
            
            // 2. Check if enough stock for new quantity
            int stockDiff = newQty - oldQty;
            if (currentStock < stockDiff) {
                return false; // Not enough stock
            }
            
            // 3. Update order total
            double newTotal = price * newQty;
            String updateOrder = "UPDATE APP.ORDERTABLE SET TOTALAMOUNT = ? WHERE ORDERID = ?";
            PreparedStatement ps = conn.prepareStatement(updateOrder);
            ps.setDouble(1, newTotal);
            ps.setString(2, orderId);
            ps.executeUpdate();
            
            // 4. Update order item quantity (if ORDERITEM table exists)
            String updateItem = "UPDATE APP.ORDERITEM SET QUANTITY = ? WHERE ORDERID = ?";
            PreparedStatement psItem = conn.prepareStatement(updateItem);
            psItem.setInt(1, newQty);
            psItem.setString(2, orderId);
            psItem.executeUpdate();
            
            // 5. Update medicine stock
            String updateStock = "UPDATE APP.MEDICINE SET STOCKQUANTITY = ? WHERE MEDICINEID = ?";
            PreparedStatement psStock = conn.prepareStatement(updateStock);
            psStock.setInt(1, currentStock - stockDiff);
            psStock.setInt(2, medicineId);
            psStock.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}