package org.example;

import org.example.database.DBManager;
import org.example.model.Salary;
import org.example.util.CSVExporter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            DBManager.initializeDatabase();
            DBManager.insertRandomData(100);
            logger.info("Data inserted successfully.");

            System.out.println("Highest Salary:");
            System.out.println(DBManager.getHighestSalaryEmployee());
            logger.info("Highest Salary retrieved successfully.");
            List<Salary> highEarners = DBManager.getEmployeesWithSalaryAbove(10000);
            logger.info("Employees with Salary Above 10000 retrieved successfully.");
            CSVExporter.exportToCSV(highEarners, "high_earners.csv");

            List<Salary> recentJoinees = DBManager.getEmployeesJoinedLastMonth();
            CSVExporter.exportToCSV(recentJoinees, "recent_joinees.csv");
            logger.info("Employees Joined Last Month retrieved successfully.");

            System.out.println("\nEmployees Sorted By Name:");
            DBManager.getEmployeesSortedByName().forEach(System.out::println);
            logger.info("Employees Sorted By Name retrieved successfully.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
