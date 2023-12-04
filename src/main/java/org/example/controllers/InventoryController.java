package org.example.controllers;



import org.example.models.Item;
import org.example.services.InventoryService;
import org.example.views.AddItemView;
import org.example.views.InventoryView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class InventoryController {

    private InventoryView inventoryView;
    private InventoryService inventoryService;

    private AddItemView addItemView;

    private InventoryController self = this;

    public InventoryController(InventoryView inventoryView, InventoryService inventoryService) {
        this.inventoryView = inventoryView;
        this.inventoryService = inventoryService;

        // Attach listeners to UI components
        this.inventoryView.addAddItemListener(new AddItemListener());
        this.inventoryView.addRemoveItemListener(new RemoveItemListener());
        this.inventoryView.addUpdateItemListener(new UpdateItemListener());

        // load inventory from database
        loadInventoryData();

    }

    // Method to load inventory data and populate the UI
    public void loadInventoryData() {
        List<Item> items = inventoryService.getAllItems();
        inventoryView.displayItems(items);
    }

    public AddItemView getAddItemView() {
        return addItemView;
    }


    // ActionListener for adding an item
    public class AddItemListener
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // open add item dialog window
            EventQueue.invokeLater(() -> {
                addItemView = new AddItemView();
                new AddItemDialogController(self);
            });

        }
    }

    // ActionListener for removing an item
    public class RemoveItemListener
            implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get selected item
            Item selectedItem = inventoryService.getItemAtIndex(inventoryView.getSelectedInventoryItemIndex());

            // Remove the item via the service
            inventoryService.removeItem(selectedItem);

            // reload the data form database
            loadInventoryData();


        }
    }

    // ActionListener for updating an item
    public class UpdateItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Refresh inventory display after update

        }
    }

    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public class addDashboardButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            onBackToDashboard();
        }

        // open dashboard window
        public void onBackToDashboard()
        {
            EventQueue.invokeLater(() ->
            {

                // open dashboard
            });



        }

    }
}
