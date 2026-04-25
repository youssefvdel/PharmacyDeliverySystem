import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:derby:./pharmacyDB;create=true";
        System.out.println("Current directory: " + System.getProperty("user.dir"));
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            System.out.println("Database connected");
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM Medicine");
            if (rs.next()) {
                System.out.println("Medicines in DB: " + rs.getInt("count"));
            }
            rs.close();
            
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
