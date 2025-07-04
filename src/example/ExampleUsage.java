-- Active: 1747592540462@@127.0.0.1@3306
// Make sure the DBConnection class is in the 'db' package and compiled properly.
import db.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

public class ExampleUsage {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = db.DBConnection.getConnection()) {
                // Use the connection (e.g., create Statement, execute queries)
                System.out.println("Connected to the database!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            System.err.println("SQL Exception: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}