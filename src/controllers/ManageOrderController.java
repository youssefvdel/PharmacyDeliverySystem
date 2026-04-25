package controllers;

import java.sql.*;
import util.DatabaseConnection;

public class ManageOrderController {

    public boolean placeOrder(String customerId, double total, String address) {
        String id = "O" + System.currentTimeMillis();
        String sql = "INSERT INTO OrderTable (orderId, customerId, totalAmount, deliveryAddress, status) VALUES (?, ?, ?, ?, 'Pending')";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2, customerId);
            ps.setDouble(3, total);
            ps.setString(4, address);
            return ps.executeUpdate() > 0;
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
