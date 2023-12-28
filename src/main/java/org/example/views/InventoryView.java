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

public class InventoryView extends JPanel {
    // Components for Inventory Management Screen
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

        inventoryTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new BetterScrollPane(inventoryTable);

        setLayout(new BorderLayout());

        // Add components to the main panel
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);


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
