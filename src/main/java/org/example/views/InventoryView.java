package org.example.views;

import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterScrollPane;
import org.example.views.view_components.BetterTable;
import org.example.controllers.InventoryController;
import org.example.controllers.NavBarController;
import org.example.models.Product;
import org.example.services.InventoryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventoryView extends BetterFrame {
    // Components for Inventory Management Screen
    private JPanel mainPanel;
    private BetterTable inventoryTable;
    private BetterScrollPane tableScrollPane;

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

        // Create navbar
        var navBar = new NavBar();
        var navBarController = new NavBarController(navBar, this);

        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        inventoryTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new BetterScrollPane(inventoryTable);

        mainPanel.add(navBar, BorderLayout.NORTH);


        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        var invView = new InventoryView();
        var invService = new InventoryService();
        var invController = new InventoryController(invView, invService);
    }


    public void displayItems(List<Product> products) {
        // Convert list of items to table data format
        String[][] rowData = new String[products.size()][0];
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
