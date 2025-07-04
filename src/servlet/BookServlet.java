package servlet;

import db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int flightId = Integer.parseInt(req.getParameter("flightId"));
        int userId = 1; // Static for now; in production, use session.

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO bookings (user_id, flight_id) VALUES (?, ?)");
            ps.setInt(1, userId);
            ps.setInt(2, flightId);
            ps.executeUpdate();

            res.getWriter().write("Flight booked successfully!");
        } catch (SQLException e) {
            res.getWriter().write("Booking failed: " + e.getMessage());
        }
    }
}
