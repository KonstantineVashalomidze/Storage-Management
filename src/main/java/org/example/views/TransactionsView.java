package org.example.views;

import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterTable;
import org.example.controllers.NavBarController;
import org.example.models.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TransactionsView extends BetterFrame {
    private JPanel mainPanel;
    private BetterTable transactionsTable;
    private JScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = { "Transaction ID", "Date", "Total Cost", "Customer ID", "Product ID", "Discounts/Promotions Applied" };

    // Create table for purchases display
    private String[][] rowData = new String[][] {  };
    public TransactionsView()
    {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Transaction Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create navbar
        var navBar = new NavBar();
        var navBarController = new NavBarController(navBar, this);


        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create buttons


        transactionsTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(transactionsTable);

        mainPanel.add(navBar, BorderLayout.NORTH);


        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void displayTransactions(List<Transaction> transactions) {
        // Convert list of items to table data format
        String[][] rowData = new String[transactions.size()][0];
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            rowData[i] = new String[]{
                    transaction.getTransactionID(),
                    transaction.getDate(),
                    transaction.getTotalCost(),
                    transaction.getCustomerID(),
                    transaction.getProductID(),
                    transaction.getDiscountsApplied()
            };
        }
        transactionsTable.setModel(new DefaultTableModel(rowData, columnHeaders));
    }

    public int getSelectedTransactionIndex() {
        return transactionsTable.getSelectedRow();
    }



}
