package controllers;

import exceptions.InvalidSelectionException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Courier;
import model.Order;
import util.DatabaseConnection;

public class AssignCourierController {

    public List<Order> getPendingOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM OrderTable WHERE status = 'Pending'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getString("orderId"));
                order.setCustomerId(rs.getString("customerId"));
                order.setDeliveryAddress(rs.getString("deliveryAddress"));
                order.setTotalAmount(rs.getDouble("totalAmount"));
                String statusStr = rs.getString("status");
                if (statusStr != null) {
                    order.setStatus(enums.OrderStatus.valueOf(statusStr.toUpperCase()));
                }
                order.setOrderDate(rs.getString("orderDate"));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Courier> getAvailableCouriers() {
        List<Courier> couriers = new ArrayList<>();
        String sql = "SELECT c.*, s.name, s.email, s.password, s.phonenum " +
                     "FROM Courier c JOIN Staff s ON c.staffId = s.staffId " +
                     "WHERE c.isAvailable = true";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Courier courier = new Courier(
                    rs.getString("courierId"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phonenum"),
                    rs.getBoolean("isAvailable")
                );
                couriers.add(courier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return couriers;
    }

    public void assignCourier(String orderId, String courierId) throws InvalidSelectionException {
        if (orderId == null || courierId == null) {
            throw new InvalidSelectionException();
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            String sql1 = "UPDATE OrderTable SET courierId=?, status='Confirmed' WHERE orderId=?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, courierId);
            ps1.setString(2, orderId);
            ps1.executeUpdate();

            String sql2 = "UPDATE Courier SET isAvailable=false WHERE courierId=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, courierId);
            ps2.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error during assignment");
        }
    }
}
