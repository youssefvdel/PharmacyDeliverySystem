package controllers;

import exceptions.InvalidProfileException;
import model.Customer;
import java.sql.*;
import util.DatabaseConnection;

public class ManageProfileController {

    public Customer loadCustomer(String customerId) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE customerId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getString("customerId"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    "", "", ""
                );
            }
        }
        return null;
    }

    public boolean validateInput(Customer customer) throws InvalidProfileException {
        if (customer.getName() == null || customer.getName().isEmpty())
            throw new InvalidProfileException("Name cannot be empty.");
        if (customer.getEmail() == null || !customer.getEmail().contains("@"))
            throw new InvalidProfileException("Invalid email. Must contain '@'.");
        if (customer.getPhone() == null || customer.getPhone().isEmpty())
            throw new InvalidProfileException("Phone number cannot be empty.");
        return true;
    }

    public boolean updateProfile(Customer customer) throws InvalidProfileException, SQLException {
        validateInput(customer);
        String sql = "UPDATE Customer SET name = ?, email = ?, password = ?, phone = ?, address = ? WHERE customerId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPassword());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getStreet());
            ps.setString(6, customer.getCustomerId());
            return ps.executeUpdate() > 0;
        }
    }
}
