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
             ResultSet rs = stmt.executeQuery("SELECT * FROM Medicine")) {
            while (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("medicineId"));
                m.setName(rs.getString("name"));
                m.setCategory(rs.getString("category"));
                m.setPrice(rs.getDouble("price"));
                m.setStockQuantity(rs.getInt("stockQuantity"));
                m.setExpiryDate(rs.getString("expiryDate"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateStock(int medicineId, int newQty) {
        String sql = "UPDATE Medicine SET stockQuantity=? WHERE medicineId=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newQty);
            ps.setInt(2, medicineId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
