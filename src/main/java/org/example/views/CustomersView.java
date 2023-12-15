package org.example.views;

import org.example.controllers.CustomersController;
import org.example.controllers.NavBarController;
import org.example.models.Customer;
import org.example.models.Product;
import org.example.services.CustomersService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CustomersView 
    extends JFrame
{
    private JPanel mainPanel;
    private JButton addButton, removeButton;
    private JTable customersTable;
    private JScrollPane tableScrollPane;

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

        // Create buttons
        addButton = new JButton("Add Customer");
        removeButton = new JButton("Remove Customer");


        customersTable = new JTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(customersTable);

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

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }




}
