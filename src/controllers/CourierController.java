package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Order;
import enums.OrderStatus;
import util.DBConnection;

/**
 *
 * @author tareq
 */


public class CourierController {

    public List<Order> getMyOrders(String courierId) {

        List<Order> orders = new ArrayList<>();

        String sql = "SELECT * FROM ORDER_TABLE WHERE COURIER_ID = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, courierId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Order order = new Order(
                    rs.getString("ORDER_ID"),
                    rs.getString("CUSTOMER_ID"),
                    null,
                    rs.getString("ORDER_DATE"),
                    OrderStatus.valueOf(rs.getString("STATUS")),
                    rs.getDouble("TOTAL_AMOUNT"),
                    "", "", "", new java.util.Date()
                );

                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }
    
    public void updateOrderStatus(String orderId, String status) {

    String sql = "UPDATE ORDER_TABLE SET STATUS = ? WHERE ORDER_ID = ?";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, status);
        ps.setString(2, orderId);

        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}