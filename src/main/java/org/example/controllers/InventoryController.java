package org.example.controllers;



import org.example.models.Product;
import org.example.services.InventoryService;
import org.example.util.DatabaseUtil;
import org.example.views.AddProductView;
import org.example.views.InventoryView;

import java.awt.*;
import java.awt.event.ActionListener;


public class InventoryController implements Controller {

    private InventoryView inventoryView;
    private InventoryService inventoryService;

    public InventoryController(InventoryView inventoryView, InventoryService inventoryService) {
        this.inventoryView = inventoryView;
        this.inventoryService = inventoryService;

        // Attach listeners to UI components
        this.inventoryView.getAddButton().addActionListener(onAddClk());
        this.inventoryView.getRemoveButton().addActionListener(onRemoveClk());

        // load inventory from database
        loadInventoryData();

    }

    // Method to load inventory data and populate the UI
    public void loadInventoryData() {
        var products = inventoryService.getAllProducts();
        inventoryView.displayItems(products);
    }


    // ActionListener for adding an item
    private ActionListener onAddClk()
    {
        return (e) -> {
            // open add item dialog window

        };
    }

    // ActionListener for removing an item
    private ActionListener onRemoveClk()
    {
        return (e) -> {
            // Get selected item
            Product selectedProduct = inventoryService.getProductAtIndex(inventoryView.getSelectedInventoryItemIndex());

            // Remove the item via the service
            inventoryService.removeProduct(selectedProduct);

            // reload the data form database
            loadInventoryData();
        };
    }

    private ActionListener onDashboardClk()
    {
        return (e) -> {

        };
    }






    public InventoryView getInventoryView() {
        return inventoryView;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }


}
