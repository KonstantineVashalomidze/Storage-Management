package org.example.views;

import org.example.views.view_components.BetterButton;
import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterTable;
import org.example.controllers.NavBarController;
import org.example.models.Purchase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PurchasesView 
    extends BetterFrame
{
    private JPanel mainPanel;
    private BetterButton addButton, removeButton;
    private BetterTable purchasesTable;
    private JScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = { "Purchase ID", "Purchase Date", "Delivery Date", "Quantity", "Supplier Id", "Product Id", "User Id" };

    // Create table for purchases display
    private String[][] rowData = new String[][] {  };
    public PurchasesView()
    {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Purchases Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create navbar
        var navBar = new NavBar();
        var navBarController = new NavBarController(navBar, this);


        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create buttons
        addButton = new BetterButton("Add Purchase");
        removeButton = new BetterButton("Remove Purchase");


        purchasesTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(purchasesTable);

        mainPanel.add(navBar, BorderLayout.NORTH);


        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void displayPurchases(List<Purchase> purchases) {
        // Convert list of items to table data format
        String[][] rowData = new String[purchases.size()][0];
        for (int i = 0; i < purchases.size(); i++) {
            Purchase purchase = purchases.get(i);
            rowData[i] = new String[]{
                    purchase.getPurchaseID(),
                    purchase.getPurchaseDate(),
                    purchase.getDeliveryDate(),
                    purchase.getQuantity(),
                    purchase.getSupplierID(),
                    purchase.getProductID(),
                    purchase.getUserID()
            };
        }
        purchasesTable.setModel(new DefaultTableModel(rowData, columnHeaders));
    }

    public int getSelectedPurchaseIndex() {
        return purchasesTable.getSelectedRow();
    }

    public BetterButton getAddButton() {
        return addButton;
    }

    public BetterButton getRemoveButton() {
        return removeButton;
    }





}
