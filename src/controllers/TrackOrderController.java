package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import util.DatabaseConnection;

public class TrackOrderController {

    public Order getOrderStatus(String orderId) {
        String sql = "SELECT * FROM OrderTable WHERE orderId=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setCustomerId(rs.getString("customerId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setDeliveryAddress(rs.getString("deliveryAddress"));
                String status = rs.getString("status");
                if (status != null) {
                    order.setStatus(enums.OrderStatus.valueOf(status.toUpperCase()));
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> getOrderHistory(String customerId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM OrderTable WHERE customerId=? ORDER BY orderDate DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setCustomerId(rs.getString("customerId"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setDeliveryAddress(rs.getString("deliveryAddress"));
                order.setStatus(enums.OrderStatus.valueOf(rs.getString("status").toUpperCase()));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }
}
