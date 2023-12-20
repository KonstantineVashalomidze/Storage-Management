package org.example.controllers;



import org.example.models.Product;
import org.example.services.InventoryService;
import org.example.views.InventoryView;

import java.awt.*;
import java.awt.event.ActionListener;


public class InventoryController implements Controller {

    private InventoryView inventoryView;
    private InventoryService inventoryService;

    public InventoryController(InventoryView inventoryView, InventoryService inventoryService) {
        this.inventoryView = inventoryView;
        this.inventoryService = inventoryService;

        // load inventory from database
        loadInventoryData();

    }

    // Method to load inventory data and populate the UI
    public void loadInventoryData() {
        var products = inventoryService.getAllProducts();
        inventoryView.displayItems(products);
    }





}
