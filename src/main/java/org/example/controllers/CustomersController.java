package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.services.CustomersService;
import org.example.util.DatabaseUtil;
import org.example.views.CustomersView;
import java.awt.event.ActionListener;

public class CustomersController
{
    private CustomersView customersView;
    private CustomersService customersService;

    public CustomersController(CustomersView customersView, CustomersService customersService)
    {
        this.customersView = customersView;
        this.customersService = customersService;

        // Attach listeners to UI components
        this.customersView.getAddButton().addActionListener(onAddClk());
        this.customersView.getRemoveButton().addActionListener(onRemoveClk());

        loadCustomersData();

    }
    public void loadCustomersData()
    {
        var customers = DatabaseUtil.getInstance().getAllTheCustomers();
        customersView.displayCustomers(customers);
    }


    private ActionListener onAddClk()
    {
        return (e) -> {

        };
    }

    // ActionListener for removing an item
    private ActionListener onRemoveClk()
    {
        return (e) -> {
            // Get selected item
            Customer selectedCustomer = customersService.getCustomerAtIndex(customersView.getSelectedCustomerIndex());

            // Remove the item via the service
            customersService.removeCustomer(selectedCustomer);

            // reload the data form database
            loadCustomersData();
        };
    }



}
