package servlet;

import db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res.sendRedirect("search.html");
            } else {
                res.getWriter().println("Invalid credentials. <a href='login.html'>Try again</a>");
            }
        } catch (SQLException e) {
            res.getWriter().println("Error: " + e.getMessage());
        }
    }
}
