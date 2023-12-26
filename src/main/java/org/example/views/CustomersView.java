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
    extends BetterFrame
{
    private JPanel mainPanel;
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
        setTitle("Customers Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create navbar
        var navBar = new NavBar();
        var navBarController = new NavBarController(navBar, this);


        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        customersTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new BetterScrollPane(customersTable);

        mainPanel.add(navBar, BorderLayout.NORTH);

        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
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
