package org.example;

import org.example.database.DBManager;
import org.example.model.Salary;
import org.example.util.CSVExporter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DBManager.initializeDatabase();
            DBManager.insertRandomData(100);

            System.out.println("Highest Salary:");
            System.out.println(DBManager.getHighestSalaryEmployee());

            List<Salary> highEarners = DBManager.getEmployeesWithSalaryAbove(10000);
            CSVExporter.exportToCSV(highEarners, "high_earners.csv");

            List<Salary> recentJoinees = DBManager.getEmployeesJoinedLastMonth();
            CSVExporter.exportToCSV(recentJoinees, "recent_joinees.csv");

            System.out.println("\nEmployees Sorted By Name:");
            DBManager.getEmployeesSortedByName().forEach(System.out::println);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
