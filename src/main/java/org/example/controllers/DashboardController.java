package org.example.controllers;

import org.example.models.User;
import org.example.views.DashboardView;

public class DashboardController {
    private DashboardView dashboardView;
    private User currentUser; // Assuming user authentication is already handled


    public DashboardController(User currentUser, DashboardView dashboardView) {
        this.currentUser = currentUser;
        this.dashboardView = dashboardView;
        this.initializeView();
        this.attachEventListeners();
    }
    private void initializeView() {
        // Assuming dashboardView contains methods to set up UI elements (labels, buttons, tables, etc.)

        // Set up labels
        dashboardView.setHeaderLabel("Welcome, " + currentUser.getUsername());
        // dashboardView.setStatusLabel("Logged in as: " + currentUser.getRole());

        // Additional UI setup as needed for the dashboard view
    }

    private void attachEventListeners() {
        // Add action listeners to the UI components (buttons, etc.)
        // e.g., for button clicks to perform specific actions

    }




}
