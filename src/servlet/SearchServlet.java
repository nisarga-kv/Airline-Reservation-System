package servlet;

import db.DBConnection;
import model.Flight;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.google.gson.Gson;

public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");

        List<Flight> flights = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM flights WHERE source=? AND destination=?");
            ps.setString(1, source);
            ps.setString(2, destination);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                flights.add(new Flight(
                    rs.getInt("id"),
                    rs.getString("flight_no"),
                    rs.getDate("date").toString(),
                    rs.getInt("seats_available")
                ));
            }

            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            res.getWriter().write(new Gson().toJson(flights));
        } catch (SQLException e) {
            res.getWriter().println("Error: " + e.getMessage());
        }
    }
}
