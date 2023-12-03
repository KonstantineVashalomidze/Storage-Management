package org.example.controllers;



import org.example.models.Item;
import org.example.services.InventoryService;
import org.example.views.AddItemDialog;
import org.example.views.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryController {

    private InventoryView inventoryView;
    private InventoryService inventoryService;

    public InventoryController(InventoryView inventoryView, InventoryService inventoryService) {
        this.inventoryView = inventoryView;
        this.inventoryService = inventoryService;

        // Attach listeners to UI components
        this.inventoryView.addAddItemListener(new AddItemListener());
        this.inventoryView.addRemoveItemListener(new RemoveItemListener());
        this.inventoryView.addUpdateItemListener(new UpdateItemListener());

        // Load initial inventory data
        loadInventoryData();
    }

    // Method to load inventory data and populate the UI
    private void loadInventoryData() {
        List<Item> items = inventoryService.getAllItems();
        inventoryView.displayItems(items);
    }

    // ActionListener for adding an item
    public class AddItemListener
            implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Refresh inventory display after addition
            loadInventoryData();

        }

        public void onAddItem() {
            // This method could be used for additional actions or handling after adding an item
            // For example:
            // Show a success message or perform another action related to adding an item
            EventQueue.invokeLater(() -> {
                AddItemDialog addItemDialog = new AddItemDialog(inventoryView);
                // Show success message using a JOptionPane dialog
                JOptionPane.showMessageDialog(addItemDialog, "Item added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            });
        }
    }

    // ActionListener for removing an item
    public class RemoveItemListener
            implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get selected item from the view
            Item selectedItem = inventoryView.getSelectedInventoryItem();

            // Remove the item via the service
            inventoryService.removeItem(selectedItem);

            // Refresh inventory display after removal
            loadInventoryData();
        }

        public void onRemoveItem() {
            // This method could be used for additional actions or handling after removing an item
            // For example:
            // Show a message or perform another action related to removing an item
            System.out.println("Item removed successfully!");
        }
    }

    // ActionListener for updating an item
    public class UpdateItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Refresh inventory display after update
            loadInventoryData();
        }
    }
}
