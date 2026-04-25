package controllers;

import exceptions.InvalidSelectionException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Courier;
import model.Order;
import enums.OrderStatus;

public class AssignCourierController {

    // get pending orders
    public List<Order> getPendingOrders() {

        List<Order> orders = new ArrayList<>();

        String sql = "SELECT * FROM ORDER_TABLE WHERE STATUS = 'PENDING'";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                // 🔹 courier = null initially (not assigned yet)
                Courier courier = null;

                // 🔹 convert status string → enum
                OrderStatus status = OrderStatus.valueOf(rs.getString("STATUS"));

                Order order = new Order(
                    rs.getString("ORDER_ID"),
                    rs.getString("CUSTOMER_ID"),
                    courier,
                    rs.getString("ORDER_DATE"), // now string
                    status,
                    rs.getDouble("TOTAL_AMOUNT"),
                    rs.getString("DELIVERY_ADDRESS"),      // make sure column exists
                    rs.getString("ESTIMATED_DELIVERY"),    // make sure column exists
                    rs.getString("CURRENT_STATUS"),        // make sure column exists
                    rs.getTimestamp("LAST_UPDATED")        // Date
                );

                orders.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    // get available couriers
    public List<Courier> getAvailableCouriers() {

        List<Courier> couriers = new ArrayList<>();

        String sql =
            "SELECT * FROM STAFF WHERE ROLE='COURIER' AND IS_AVAILABLE=1";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Courier courier = new Courier(
                    rs.getString("STAFF_ID"),
                    rs.getString("NAME"),
                    rs.getString("EMAIL"),
                    rs.getString("PASSWORD"),
                    rs.getString("PHONE"),
                    rs.getInt("IS_AVAILABLE") == 1
                );

                couriers.add(courier);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return couriers;
    }

    // assign courier
    public void assignCourier(String orderId, String courierId)
        throws InvalidSelectionException {

        if (orderId == null || courierId == null) {
            throw new InvalidSelectionException();
        }

        try (Connection conn = DBConnection.getConnection()) {

            conn.setAutoCommit(false);

            // 🔹 update order
            String sql1 =
                "UPDATE ORDER_TABLE SET COURIER_ID=?, STATUS='CONFIRMED' WHERE ORDER_ID=?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, courierId);
            ps1.setString(2, orderId);
            ps1.executeUpdate();

            // update courier
            String sql2 = "UPDATE STAFF SET IS_AVAILABLE=0 WHERE STAFF_ID=?";
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