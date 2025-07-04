-- Active: 1747592540462@@127.0.0.1@3306
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        String url = "jdbc:mysql://localhost:3306/airlinereservationsystem";
        String user = "root";
        String password = "admin"; // Change this to your actual MySQL password
        return DriverManager.getConnection(url, user, password);
    }
}

// filepath: c:\airlinereservationsystem\src\db\DBConnection.java
