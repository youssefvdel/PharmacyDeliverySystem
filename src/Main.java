import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.derby.client.am.ConnectionCallbackInterface;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:derby:pharmacyDB;";
        String userName = "admin";
        String password = "admin";
        Connection connection = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("database connected");
        } catch (Exception e) {
            System.out.println("connection error");
            e.printStackTrace();
        }
    }
}
