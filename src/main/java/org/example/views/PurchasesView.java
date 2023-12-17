package org.example.views;

import org.example.controllers.NavBarController;
import org.example.controllers.PurchasesController;
import org.example.models.Purchase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PurchasesView 
    extends JFrame
{
    private JPanel mainPanel;
    private JButton addButton, removeButton;
    private JTable purchasesTable;
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
        addButton = new JButton("Add Purchase");
        removeButton = new JButton("Remove Purchase");


        purchasesTable = new JTable(rowData, columnHeaders);
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

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }





}
