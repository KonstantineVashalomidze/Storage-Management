package org.example.views;

import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterScrollPane;
import org.example.views.view_components.BetterTable;
import org.example.controllers.NavBarController;
import org.example.models.Customer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CustomersView 
    extends JPanel
{
    private BetterTable customersTable;
    private BetterScrollPane tableScrollPane;
    // Define column headers at the class level
    private final String[] columnHeaders = { "Customer ID", "Customer Name", "Contact Information" };
    // Create table for customers display
    private String[][] rowData = new String[][] {  };
    public CustomersView()
    {
        initializeUI();        
    }
    private void initializeUI() {



        // Initialize main panel and layout
        setLayout(new BorderLayout());

        customersTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new BetterScrollPane(customersTable);

        // Add components to the main panel
        add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);



    }


    // displays search result
    public void displaySearchResult(List<Customer> customers)
    {
        displayCustomers(customers);
    }



    public void displayCustomers(List<Customer> customers) {
        // Convert list of items to table data format
        String[][] rowData = new String[customers.size()][0];
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            rowData[i] = new String[]{
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getContactInformation()
            };
        }
        customersTable.setModel(new DefaultTableModel(rowData, columnHeaders));
    }

    public int getSelectedCustomerIndex() {
        return customersTable.getSelectedRow();
    }






}
