package org.example.views;

import org.example.controllers.InventoryController;
import org.example.models.Product;
import org.example.services.InventoryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventoryView extends JFrame {
    // Components for Inventory Management Screen
    private JPanel mainPanel;
    private JButton addButton, removeButton, dashBoardButton;
    private JTable inventoryTable;
    private JScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = {"Product Name", "Category", "Selling Price", "Image", 
            "Stock Quantity", "Description", "Cost Price", "Minimum Stock Level", "Unit of Measure", "Date Added"
            , "Last Updated", "Product ID" };

    // Create table for inventory display
    private String[][] rowData = new String[][] {  };


    public InventoryView() {
        initializeUI();
    }




    private void initializeUI() {
        setTitle("Inventory Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create buttons
        addButton = new JButton("Add Product");
        removeButton = new JButton("Remove Product");
        dashBoardButton = new JButton("Back to Dashboard");


        inventoryTable = new JTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(inventoryTable);

        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(dashBoardButton);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void addDashboardButtonListener(InventoryController.addDashboardButtonListener listener) {
        dashBoardButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        var invView = new InventoryView();
        var invService = new InventoryService();
        var invController = new InventoryController(invView, invService);
    }


    public void addAddItemListener(InventoryController.AddItemListener listener) {
        addButton.addActionListener(listener);
    }

    public void addRemoveItemListener(InventoryController.RemoveItemListener listener) {
        removeButton.addActionListener(listener);
    }

    public void addUpdateItemListener(InventoryController.UpdateItemListener listener) {
        // Implement update listener if needed
        // Example: For a row selection to update an product
    }

    public void displayItems(List<Product> products) {
        // Convert list of items to table data format
        String[][] rowData = new String[products.size()][5];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            rowData[i] = new String[]{
                    product.getProductName(),
                    product.getCategory(),
                    String.valueOf(product.getSellingPrice()),
                    product.getImage(),
                    String.valueOf(product.getStockQuantity()),
                    product.getDescription(),
                    String.valueOf(product.getCostPrice()),
                    String.valueOf(product.getMinimumStockLevel()),
                    product.getUnitOfMeasure(),
                    String.valueOf(product.getDateAdded()),
                    String.valueOf(product.getLastUpdated()),
                    String.valueOf(product.getProductID())
            };
        }
        inventoryTable.setModel(new DefaultTableModel(rowData, columnHeaders));
    }

    public int getSelectedInventoryItemIndex() {
        return inventoryTable.getSelectedRow();

    }

}
