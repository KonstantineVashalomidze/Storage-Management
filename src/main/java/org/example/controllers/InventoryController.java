package org.example.controllers;



import org.example.models.Item;
import org.example.services.InventoryService;
import org.example.views.InventoryView;

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
            // Get data from the view
            Item newItem = inventoryView.getNewItemDetails();

            // Add the item via the service
            inventoryService.addItem(newItem);

            // Refresh inventory display after addition
            loadInventoryData();
        }

        public void onAddItem() {
            // This method could be used for additional actions or handling after adding an item
            // For example:
            // Show a success message or perform another action related to adding an item
            System.out.println("Item added successfully!");
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
            // Get updated item details from the view
            Item updatedItem = inventoryView.getUpdatedItemDetails();

            // Update the item details via the service
            inventoryService.updateItem(updatedItem);

            // Refresh inventory display after update
            loadInventoryData();
        }
    }
}