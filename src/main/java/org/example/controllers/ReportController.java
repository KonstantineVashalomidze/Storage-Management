package org.example.controllers;

import org.example.models.Report;
import org.example.services.ReportService;
import org.example.util.FileUtil; // Assuming FileUtil is used for exporting reports

public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // Generate inventory report for a specific time period
    public void generateInventoryReport(String startDate, String endDate) {
        // Validate inputs before proceeding
        if (isValidDateFormat(startDate) && isValidDateFormat(endDate)) {
            Report inventoryReport = reportService.generateInventoryReport(startDate, endDate);

            // Logic to handle the generated report (e.g., display in UI, export to a file)
            // For example, exporting to a PDF file using FileUtil
            FileUtil.exportToPDF(inventoryReport);
        } else {
            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
        }
    }

    // Generate storage utilization report
    public void generateStorageUtilizationReport() {
        Report storageUtilizationReport = reportService.generateStorageUtilizationReport();

        // Handle the generated storage utilization report as needed
        // For example, display in the UI or save to a file
    }

    // Export a generated report to a specific file format (e.g., PDF, CSV)
    public void exportReport(Report report, String format) {
        // Logic to export the report to the specified format using FileUtil or related utility classes
        if (format.equalsIgnoreCase("PDF")) {
            FileUtil.exportToPDF(report);
        } else if (format.equalsIgnoreCase("CSV")) {
            FileUtil.exportToCSV(report);
        } else {
            System.out.println("Unsupported export format.");
        }
    }

    // Example method to retrieve a previously generated report
    public Report getReportById(int reportId) {
        return reportService.getReportById(reportId);
    }

    // Validate date format (Assuming date format YYYY-MM-DD)
    private boolean isValidDateFormat(String date) {
        // Implement date format validation logic
        // Return true if the date matches the expected format; otherwise, return false
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}
