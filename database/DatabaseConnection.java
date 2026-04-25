import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Database Connection Manager for Pharmacy Delivery System
 * Uses Derby Embedded with relative path (works on all team members' machines)
 */
public class DatabaseConnection {
    
    // Relative path - database folder is created in project root
    private static final String DB_URL = "jdbc:derby:./database/pharmacyDB;create=true";
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    
    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Derby driver not found. Make sure derby.jar is in classpath.");
            e.printStackTrace();
        }
    }
    
    /**
     * Get database connection
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
    
    /**
     * Initialize database - run schema and seed data
     * Call this once when application starts
     */
    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            System.out.println("Database initialized at: " + DB_URL);
            
            // Check if tables already exist
            if (!tablesExist(conn)) {
                System.out.println("Creating tables...");
                runSqlFile(conn, "./database/schema.sql");
                System.out.println("Tables created.");
                
                System.out.println("Inserting test data...");
                runSqlFile(conn, "./database/seed_data.sql");
                System.out.println("Test data inserted.");
            } else {
                System.out.println("Tables already exist. Skipping initialization.");
            }
        } catch (SQLException e) {
            System.err.println("Database initialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Check if database tables already exist
     */
    private static boolean tablesExist(Connection conn) {
        try {
            conn.createStatement().executeQuery("SELECT 1 FROM Staff FETCH FIRST 1 ROWS ONLY");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    /**
     * Execute SQL statements from a file
     */
    private static void runSqlFile(Connection conn, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             Statement stmt = conn.createStatement()) {
            
            StringBuilder sql = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("--")) continue;
                sql.append(line).append(" ");
                
                if (line.endsWith(";")) {
                    String query = sql.toString().replace(";", "").trim();
                    if (!query.isEmpty()) {
                        try {
                            stmt.execute(query);
                        } catch (SQLException e) {
                            // Ignore "already exists" errors during init
                            if (!e.getMessage().contains("already exists") && 
                                !e.getMessage().contains("X0Y32")) {
                                System.err.println("SQL Error: " + e.getMessage());
                            }
                        }
                    }
                    sql.setLength(0);
                }
            }
        } catch (IOException e) {
            System.err.println("Could not read SQL file: " + filePath);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Shutdown database (call before application exit)
     */
    public static void shutdown() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException e) {
            // Expected exception on successful shutdown
            if (!e.getSQLState().equals("XJ015")) {
                e.printStackTrace();
            }
        }
    }
}
