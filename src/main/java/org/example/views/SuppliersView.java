package org.example.views;

import org.example.views.view_components.BetterFrame;
import org.example.views.view_components.BetterTable;
import org.example.controllers.NavBarController;
import org.example.models.Supplier;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SuppliersView
    extends BetterFrame
{
    private JPanel mainPanel;
    private BetterTable suppliersTable;
    private JScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = { "Supplier ID", "Supplier Name", "Contact Information" };

    // Create table for customers display
    private String[][] rowData = new String[][] {  };





    public SuppliersView()
    {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Suppliers Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create navbar
        var navBar = new NavBar();
        var navBarController = new NavBarController(navBar, this);


        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);


        suppliersTable = new BetterTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(suppliersTable);

        mainPanel.add(navBar, BorderLayout.NORTH);


        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void displaySuppliers(List<Supplier> suppliers) {
        // Convert list of items to table data format
        String[][] rowData = new String[suppliers.size()][0];
        for (int i = 0; i < suppliers.size(); i++) {
            Supplier supplier = suppliers.get(i);
            rowData[i] = new String[]{
                    supplier.getSupplierID(),
                    supplier.getSupplierName(),
                    supplier.getContactInformation()
            };
        }
        suppliersTable.setModel(new DefaultTableModel(rowData, columnHeaders));
    }

    public int getSelectedSupplierIndex() {
        return suppliersTable.getSelectedRow();
    }



}
