package org.example.views;

import org.example.models.StorageFacility;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StorageFacilityView extends JFrame {

    // Components
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JComboBox<String> facilityComboBox;
    private JTable facilityDetailsTable;
    private JScrollPane detailsScrollPane;
    private JButton viewDetailsButton;
    private JButton addItemButton;

    // Constructor
    public StorageFacilityView() {
        initializeUI();
    }

    // Initialize UI components and layout
    private void initializeUI() {
        setTitle("Storage Facility Details");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("Select Storage Facility:");
        facilityComboBox = new JComboBox<>();
        // Populate facilityComboBox with available facilities

        facilityDetailsTable = new JTable();
        // Populate facilityDetailsTable with storage facility details
        detailsScrollPane = new JScrollPane(facilityDetailsTable);

        viewDetailsButton = new JButton("View Details");
        addItemButton = new JButton("Add Item");

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(titleLabel);
        topPanel.add(facilityComboBox);
        topPanel.add(viewDetailsButton);
        topPanel.add(addItemButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(detailsScrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }




    // Sample method to update facility details in the table
    public void updateFacilityDetails(Object[][] data, String[] columns) {
        facilityDetailsTable.setModel(new DefaultTableModel(data, columns));
    }

    // Sample method to add facility names to the combobox
    public void setFacilityNames(String[] facilityNames) {
        facilityComboBox.setModel(new DefaultComboBoxModel<>(facilityNames));
    }

    // Sample method to handle button click events (View Details or Add Item)
    public void addViewDetailsButtonListener(ActionListener listener) {
        viewDetailsButton.addActionListener(listener);
    }

    public void addAddItemButtonListener(ActionListener listener) {
        addItemButton.addActionListener(listener);
    }


    public void showStorageFacilities(List<StorageFacility> storageFacilities) {
        // Clear the existing data in the combo box
        facilityComboBox.removeAllItems();

        // Loop through the list of storage facilities and add their names to the combo box
        for (StorageFacility facility : storageFacilities) {
            facilityComboBox.addItem(facility.getName());
        }
    }

    public void showSuccessMessage(String message) {
        // Display a success message dialog box
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        // Display an error message dialog box
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
