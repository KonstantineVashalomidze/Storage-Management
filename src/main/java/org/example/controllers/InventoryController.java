package org.example.controllers;



import org.example.models.Product;
import org.example.services.InventoryService;
import org.example.views.AddProductView;
import org.example.views.InventoryView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InventoryController {

    private InventoryView inventoryView;
    private InventoryService inventoryService;

    private AddProductView addProductView;

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

    }

    public AddProductView getAddItemView() {
        return addProductView;
    }


    // ActionListener for adding an item
    public class AddItemListener
            implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // open add item dialog window
            EventQueue.invokeLater(() -> {
                addProductView = new AddProductView();
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
            Product selectedProduct = inventoryService.getProductAtIndex(inventoryView.getSelectedInventoryItemIndex());

            // Remove the item via the service
            inventoryService.removeProduct(selectedProduct);

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
