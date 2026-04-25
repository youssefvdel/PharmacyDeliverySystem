package util;

import java.sql.*;
import java.io.*;
import java.nio.file.*;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (!tablesExist(conn)) {
                System.out.println("Initializing database...");
                executeSqlFile(conn, "database/schema.sql");
                executeSqlFile(conn, "database/seed_data.sql");
                System.out.println("Database initialized successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean tablesExist(Connection conn) {
        try (ResultSet rs = conn.getMetaData().getTables(null, null, "STAFF", null)) {
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    private static void executeSqlFile(Connection conn, String filepath) throws IOException, SQLException {
        String sql = new String(Files.readAllBytes(Paths.get(filepath)));
        // Split by semicolon and execute each statement
        String[] statements = sql.split(";");
        for (String stmt : statements) {
            stmt = stmt.trim();
            if (!stmt.isEmpty() && !stmt.startsWith("--") && !stmt.startsWith("/*")) {
                try (Statement s = conn.createStatement()) {
                    s.execute(stmt);
                } catch (SQLException e) {
                    // Ignore "table already exists" errors
                    if (!e.getSQLState().equals("X0Y32")) {
                        System.err.println("SQL Error: " + e.getMessage() + " for: " + stmt.substring(0, Math.min(50, stmt.length())));
                    }
                }
            }
        }
    }
}
