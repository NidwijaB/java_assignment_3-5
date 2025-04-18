package org.example.util;

import org.example.model.Salary;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {
    public static void exportToCSV(List<Salary> salaries, String filePath) throws IOException {
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(filePath),
                CSVFormat.DEFAULT.withHeader("Employee Name", "Join Date", "Salary"))) {
            for (Salary s : salaries) {
                printer.printRecord(s.getEmployeeName(), s.getJoinDate(), s.getSalary());
            }
        }
    }
}
