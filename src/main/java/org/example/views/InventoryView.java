package org.example.views;

import org.example.controllers.InventoryController;
import org.example.models.Item;
import org.example.services.InventoryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventoryView extends JFrame {
    // Components for Inventory Management Screen
    private JPanel mainPanel;
    private JButton addButton;
    private JButton removeButton;
    private JTable inventoryTable;
    private JScrollPane tableScrollPane;

    // Define column headers at the class level
    private final String[] columnHeaders = {"Item ID", "Item Name", "Quantity", "Description", "Price"};

    // Create table for inventory display
    private String[][] rowData = {{"ID001", "Switch", "100", "Standard light switch", "90.9"},
                            {"ID002", "Socket", "80", "Universal socket outlet", "80.77"}};

    // Listener instances for buttons
    private InventoryController.AddItemListener addItemListener;
    private InventoryController.RemoveItemListener removeItemListener;
    private InventoryController.UpdateItemListener updateItemListener;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new InventoryView().setVisible(true));
    }


    public InventoryView() {
        initializeUI();
    }



    private void initializeUI() {
        setTitle("Inventory Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Initialize main panel and layout
        mainPanel = new JPanel(new BorderLayout());
        setContentPane(mainPanel);

        // Create buttons
        addButton = new JButton("Add Item");
        removeButton = new JButton("Remove Item");


        inventoryTable = new JTable(rowData, columnHeaders);
        tableScrollPane = new JScrollPane(inventoryTable);

        // Add components to the main panel
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }


    public void addAddItemListener(InventoryController.AddItemListener listener) {
        this.addItemListener = listener;
        addButton.addActionListener(e -> {
            if (addItemListener != null) {
                addItemListener.onAddItem();
            }
        });
    }

    public void addRemoveItemListener(InventoryController.RemoveItemListener listener) {
        this.removeItemListener = listener;
        removeButton.addActionListener(e -> {
            if (removeItemListener != null) {
                removeItemListener.onRemoveItem();
            }
        });
    }

    public void addUpdateItemListener(InventoryController.UpdateItemListener listener) {
        this.updateItemListener = listener;
        // Implement update listener if needed
        // Example: For a row selection to update an item
    }

    public void displayItems(List<Item> items) {
        // Convert list of items to table data format
        String[][] rowData = new String[items.size()][4];
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            rowData[i] = new String[]{
                    item.getItemId(),
                    item.getItemName(),
                    String.valueOf(item.getQuantity()),
                    item.getDescription()
            };
        }
        inventoryTable.setModel(new DefaultTableModel(rowData, columnHeaders));
    }

    public Item getNewItemDetails() {
        // Fetch new item details from UI inputs and return as Item object
        // Implement based on UI input fields for new item creation
        // Example: return new Item(itemId, itemName, quantity, description);
        return null;
    }

    public Item getSelectedInventoryItem() {
        // Get the selected row in the table and retrieve the associated Item
        int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow != -1) {
            // Retrieve data from the selected row and create an Item object
            // Example: Get data from the selected row and create an Item object
            String itemId = (String) inventoryTable.getValueAt(selectedRow, 0);
            String itemName = (String) inventoryTable.getValueAt(selectedRow, 1);
            int quantity = Integer.parseInt((String) inventoryTable.getValueAt(selectedRow, 2));
            String description = (String) inventoryTable.getValueAt(selectedRow, 3);
            double price = Double.parseDouble((String) inventoryTable.getValueAt(selectedRow, 4));

            return new Item(itemId, itemName, quantity, description, price);
        } else {
            // No item selected
            return null;
        }
    }

    public Item getUpdatedItemDetails() {
        // Fetch updated item details from UI inputs and return as Item object
        // Implement based on UI input fields for item update
        // Example: return updated Item(itemId, itemName, quantity, description);
        return null;
    }
}
