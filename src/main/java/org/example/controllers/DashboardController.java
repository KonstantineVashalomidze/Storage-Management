package org.example.controllers;

import org.example.models.User;
import org.example.services.InventoryService;
import org.example.views.DashboardView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {
    private DashboardView dashboardView;
    private User currentUser; // Assuming user authentication is already handled

    private InventoryService inventoryService; // Inject the service instance

    public DashboardController(User currentUser) {
        this.currentUser = currentUser;
        this.dashboardView = new DashboardView();
        this.dashboardView.setVisible(true);
        this.initializeView();
        this.attachEventListeners();
        this.inventoryService = new InventoryService(); // Instantiate the service
    }

    private void initializeView() {
        // Assuming dashboardView contains methods to set up UI elements (labels, buttons, tables, etc.)

        // Set up labels
        dashboardView.setHeaderLabel("Welcome, " + currentUser.getUsername());
//        dashboardView.setStatusLabel("Logged in as: " + currentUser.getRole());

        // Set up buttons
        dashboardView.getRefreshButton().setText("Refresh");
        dashboardView.getAddItemButton().setText("Add Item");
        dashboardView.getGenerateReportButton().setText("Generate Report");

        // Set up tables or other components
//        dashboardView.initializeInventoryTable(); // Initialize the inventory table

        // Additional UI setup as needed for the dashboard view
    }

    private void attachEventListeners() {
        // Add action listeners to the UI components (buttons, etc.)
        // e.g., for button clicks to perform specific actions
        dashboardView.getRefreshButton().addActionListener(e -> {
            // Logic to refresh or update dashboard data
            updateDashboardData();
        });
    }

    private void updateDashboardData() {
        // Fetch and update data displayed on the dashboard
        // e.g., update inventory information, charts, or other components
        dashboardView.updateInventoryTable(inventoryService.getInventory(currentUser));
        // Other update operations based on services
    }

    // Other methods related to dashboard functionalities can be added here

}
