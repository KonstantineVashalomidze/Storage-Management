package org.example.controllers;

import org.example.models.Item;
import org.example.services.InventoryService;
import org.example.views.AddItemView;

import java.util.UUID;

public class AddItemDialogController
{

    private InventoryController inventoryController;


    public AddItemDialogController(InventoryController inventoryController)
    {
        this.inventoryController = inventoryController;

        // add listener to the add button
        addAddItemButtonListener();

        // add Cancel button listener
        addCancelButtonListener();
    }



    private void addCancelButtonListener()
    {
        var addItemView = inventoryController.getAddItemView();
        addItemView.getCancelButton().addActionListener(e -> {
            // Close the dialog without adding the item
            addItemView.dispose();
        });
    }


    private void addAddItemButtonListener()
    {
        UUID uuid = UUID.randomUUID();
        var addItemView = inventoryController.getAddItemView();
        var inventoryService = inventoryController.getInventoryService();
        addItemView.getAddButton().addActionListener(ex -> {

            // Retrieve values from text fields
            String itemName = addItemView.getItemNameTextField().getText();
            int quantity = Integer.parseInt(addItemView.getQuantityTextField().getText());
            String description = addItemView.getDescriptionTextField().getText();
            double price = Double.parseDouble(addItemView.getPriceTextField().getText());
            String randomId = uuid.toString();

            // Create a new item using the retrieved values
            Item newItem = new Item(randomId, itemName, quantity, description, price);
            // Add the item via the service
            inventoryService.addItem(newItem);

            // reload data from db
            inventoryController.loadInventoryData();

            // Close the dialog
            addItemView.dispose();
        });
    }


}
