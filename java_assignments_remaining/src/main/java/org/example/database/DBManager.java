package org.example.database;

import org.example.model.Salary;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class DBManager {
    private static final String DB_URL = "jdbc:sqlite:java_assignments_remaining/src/main/resources/salary.db";

    public static void initializeDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS Salary (" +
                    "employee_name TEXT, join_date TEXT, salary REAL)");
        }
    }

    public static void insertRandomData(int count) throws SQLException {
        Random rand = new Random();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO Salary (employee_name, join_date, salary) VALUES (?, ?, ?)")) {
            for (int i = 0; i < count; i++) {
                String name = "Employee_" + (i + 1);
                LocalDate date = LocalDate.now().minusDays(rand.nextInt(365));
                double salary = 5000 + rand.nextInt(15000);
                pstmt.setString(1, name);
                pstmt.setString(2, date.toString());
                pstmt.setDouble(3, salary);
                pstmt.executeUpdate();
            }
        }
    }

    public static Salary getHighestSalaryEmployee() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Salary ORDER BY salary DESC LIMIT 1")) {
            if (rs.next()) {
                return new Salary(
                        rs.getString("employee_name"),
                        LocalDate.parse(rs.getString("join_date")),
                        rs.getDouble("salary"));
            }
        }
        return null;
    }

    public static List<Salary> getEmployeesWithSalaryAbove(double threshold) throws SQLException {
        List<Salary> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Salary WHERE salary > ?")) {
            pstmt.setDouble(1, threshold);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.add(new Salary(rs.getString("employee_name"),
                        LocalDate.parse(rs.getString("join_date")),
                        rs.getDouble("salary")));
            }
        }
        return result;
    }

    public static List<Salary> getEmployeesJoinedLastMonth() throws SQLException {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        List<Salary> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Salary WHERE join_date >= ?")) {
            pstmt.setString(1, oneMonthAgo.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                result.add(new Salary(rs.getString("employee_name"),
                        LocalDate.parse(rs.getString("join_date")),
                        rs.getDouble("salary")));
            }
        }
        return result;
    }

    public static List<Salary> getEmployeesSortedByName() throws SQLException {
        List<Salary> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Salary ORDER BY employee_name ASC")) {
            while (rs.next()) {
                result.add(new Salary(rs.getString("employee_name"),
                        LocalDate.parse(rs.getString("join_date")),
                        rs.getDouble("salary")));
            }
        }
        return result;
    }
}
