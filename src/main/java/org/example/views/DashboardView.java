package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardView extends JFrame {

    private JLabel titleLabel;
    private JLabel statusLabel;
    private JTable inventoryTable; // Declaration of the inventory table

    public DashboardView() {
        setTitle("Horoz Elektrik - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600)); // Set preferred size for responsiveness
        initComponents();
        pack(); // Adjust frame size
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);

        // Initialize inventoryTable (sample initialization)
        Object[][] data = { /* sample data */ };
        Object[] columnNames = { /* sample column names */ };
        initializeInventoryTable(data, columnNames);
    }


    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // Grid layout for responsive design

        titleLabel = new JLabel("Horoz Elektrik Storage Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton inventoryBtn = new JButton("Inventory");
        JButton storageBtn = new JButton("Storage Facilities");
        JButton reportBtn = new JButton("Generate Report");
        JButton settingsBtn = new JButton("Settings");

        inventoryBtn.setPreferredSize(new Dimension(200, 100)); // Set button sizes
        storageBtn.setPreferredSize(new Dimension(200, 100));
        reportBtn.setPreferredSize(new Dimension(200, 100));
        settingsBtn.setPreferredSize(new Dimension(200, 100));

        // Add action listeners for buttons here
        inventoryBtn.addActionListener(e -> {
            // Handle Inventory Button Click
            // Example: Open InventoryView or trigger inventory-related actions
            System.out.println("Inventory Button Clicked");

            EventQueue.invokeLater(() ->
                    new InventoryView().setVisible(true));

            this.dispose();
        });

        storageBtn.addActionListener(e -> {
            // Handle Storage Facilities Button Click
            // Example: Open StorageFacilityView or trigger storage-related actions
            System.out.println("Storage Facilities Button Clicked");
            EventQueue.invokeLater(() ->
                    new com.horozelektrik.storage.views.StorageFacilityView().setVisible(true));
            this.dispose();
        });

        reportBtn.addActionListener(e -> {
            // Handle Generate Report Button Click
            // Example: Generate reports or open ReportView
            System.out.println("Generate Report Button Clicked");
            EventQueue.invokeLater(() -> new ReportView().setVisible(true));
            this.dispose();
        });

        settingsBtn.addActionListener(e -> {
            // Handle Settings Button Click
            // Example: Open SettingsView or trigger settings-related actions
            System.out.println("Settings Button Clicked");
        });

        topPanel.add(titleLabel);
        centerPanel.add(inventoryBtn);
        centerPanel.add(storageBtn);
        centerPanel.add(reportBtn);
        centerPanel.add(settingsBtn);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    public JButton getRefreshButton() {
        // Return refresh button if needed in the future
        return new JButton("Refresh");
    }

    public void updateInventoryTable(Object inventory) {
        // Implement logic to update inventory table based on the provided inventory data
        // Example: Update a JTable or other components displaying inventory information
    }


    public void setHeaderLabel(String text) {
        titleLabel.setText(text);
    }

    public void setStatusLabel(String text) {
        // Assuming statusLabel is a JLabel component declared elsewhere in the class
        statusLabel.setText(text);
    }

    public JButton getAddItemButton() {
        JButton addItemBtn = new JButton("Add Item");
        addItemBtn.setPreferredSize(new Dimension(200, 100)); // Set button size
        addItemBtn.addActionListener(e -> {
            // Handle Add Item Button Click
            // Example: Open AddItemView or trigger item addition process
            System.out.println("Add Item Button Clicked");
        });
        return addItemBtn;
    }

    public JButton getGenerateReportButton() {
        JButton generateReportBtn = new JButton("Generate Report");
        generateReportBtn.setPreferredSize(new Dimension(200, 100)); // Set button size
        generateReportBtn.addActionListener(e -> {
            // Handle Generate Report Button Click
            // Example: Generate reports or open ReportView
            System.out.println("Generate Report Button Clicked");
        });
        return generateReportBtn;
    }

    public void initializeInventoryTable(Object[][] data, Object[] columnNames) {
        // Initialize the inventory table with provided data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        inventoryTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(inventoryTable); // Add table to a scroll pane if needed
        // Add additional configurations if required
        // Example: set preferred size, add to the panel, etc.
        // getContentPane().add(scrollPane);
    }

    // Assuming there's a method to update the inventory table with data
    public void updateInventoryTable(Object[][] data, Object[] columnNames) {
        // Assuming inventoryTable is a JTable component declared elsewhere in the class
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        inventoryTable.setModel(model);
    }
}