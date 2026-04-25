package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import enums.OrderStatus;
import util.DatabaseConnection;

public class CourierController {

    public List<Order> getMyOrders(String courierId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM OrderTable WHERE courierId = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, courierId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setCustomerId(rs.getString("customerId"));
                order.setDeliveryAddress(rs.getString("deliveryAddress"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                order.setOrderDate(rs.getString("orderDate"));
                String statusStr = rs.getString("status");
                if (statusStr != null) {
                    order.setStatus(OrderStatus.valueOf(statusStr.toUpperCase()));
                }
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void updateOrderStatus(String orderId, String status) {
        String sql = "UPDATE OrderTable SET status = ? WHERE orderId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
