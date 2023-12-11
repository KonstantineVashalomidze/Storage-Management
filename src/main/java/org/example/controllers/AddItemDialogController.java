package org.example.controllers;

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

    }


}
