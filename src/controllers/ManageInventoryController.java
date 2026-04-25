package controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Medicine;
import util.DatabaseConnection;

public class ManageInventoryController {

    public List<Medicine> getAllMedicines() {
        List<Medicine> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Medicine ORDER BY medicineId")) {
            while (rs.next()) {
                list.add(mapMedicine(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> searchByName(String query) {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE LOWER(name) LIKE ? ORDER BY medicineId";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + query.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapMedicine(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Medicine> searchById(int id) {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM Medicine WHERE medicineId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                list.add(mapMedicine(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addMedicine(String name, String category, double price, int stock, String expiry) {
        String sql = "INSERT INTO Medicine (name, category, price, stockQuantity, expiryDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, category);
            ps.setDouble(3, price);
            ps.setInt(4, stock);
            ps.setString(5, expiry);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMedicine(int id, String name, double price, int stock, String category) {
        String sql = "UPDATE Medicine SET name=?, price=?, stockQuantity=?, category=? WHERE medicineId=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, stock);
            ps.setString(4, category);
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMedicine(int id) {
        String sql = "DELETE FROM Medicine WHERE medicineId=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Medicine mapMedicine(ResultSet rs) throws SQLException {
        Medicine m = new Medicine();
        m.setMedicineId(rs.getInt("medicineId"));
        m.setName(rs.getString("name"));
        m.setCategory(rs.getString("category"));
        m.setPrice(rs.getDouble("price"));
        m.setStockQuantity(rs.getInt("stockQuantity"));
        m.setExpiryDate(rs.getString("expiryDate"));
        return m;
    }
}
