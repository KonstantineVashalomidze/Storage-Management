package org.example.views;

import org.example.controllers.CustomersController;
import org.example.controllers.NavBarController;
import org.example.models.Customer;
import org.example.models.Supplier;
import org.example.services.CustomersService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SuppliersView
    extends JFrame
{
    private JPanel mainPanel;
    private JButton addButton, removeButton;
    private JTable suppliersTable;
    private JScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = { "Supplier ID", "Supplier Name", "Contact Information" };

    // Create table for customers display
    private String[][] rowData = new String[][] {  };


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

        });
    }


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

        // Create buttons
        addButton = new JButton("Add Supplier");
        removeButton = new JButton("Remove Supplier");


        suppliersTable = new JTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(suppliersTable);

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

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

}
