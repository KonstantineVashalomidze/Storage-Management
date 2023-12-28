package org.example.views;

import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterScrollPane;
import org.example.views.view_components.BetterTable;
import org.example.controllers.NavBarController;
import org.example.models.Transaction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TransactionsView extends JPanel {
    private BetterTable transactionsTable;
    private BetterScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = { "Transaction ID", "Date", "Total Cost", "Customer ID", "Product ID", "Discounts/Promotions Applied" };

    // Create table for purchases display
    private String[][] rowData = new String[][] {  };
    public TransactionsView()
    {
        initializeUI();
    }
    private void initializeUI() {


        // Initialize main panel and layout
        setLayout(new BorderLayout());

        transactionsTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new BetterScrollPane(transactionsTable);



        // Add components to the main panel
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);


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
