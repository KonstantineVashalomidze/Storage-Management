package org.example.controllers;

import org.example.views.AddProductView;

public class AddProductViewController
    implements Controller
{


    private AddProductView addProductView;

    public AddProductViewController(AddProductView addProductView)
    {
        this.addProductView = addProductView;

        // add listener to the add button
        addAddItemButtonListener();

        // add Cancel button listener
        addCancelButtonListener();
    }

    public AddProductView getAddProductView() {
        return addProductView;
    }

    private void addCancelButtonListener()
    {

    }


    private void addAddItemButtonListener()
    {

    }


}
