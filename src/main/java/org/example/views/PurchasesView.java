package org.example.views;

import org.example.views.view_components.BetterButton;
import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterScrollPane;
import org.example.views.view_components.BetterTable;
import org.example.controllers.NavBarController;
import org.example.models.Purchase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PurchasesView 
    extends JPanel
{
    private BetterButton addButton, removeButton;
    private BetterTable purchasesTable;
    private BetterScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = { "Purchase ID", "Purchase Date", "Delivery Date", "Quantity", "Supplier Id", "Product Id", "User Id" };

    // Create table for purchases display
    private String[][] rowData = new String[][] {  };
    public PurchasesView()
    {
        initializeUI();
    }
    private void initializeUI() {



        // Initialize main panel and layout
        setLayout(new BorderLayout());

        // Create buttons
        addButton = new BetterButton("Add Purchase");
        removeButton = new BetterButton("Remove Purchase");


        purchasesTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new BetterScrollPane(purchasesTable);



        // Add components to the main panel
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);



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
