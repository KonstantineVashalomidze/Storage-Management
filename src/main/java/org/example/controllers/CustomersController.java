package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.services.CustomersService;
import org.example.util.DatabaseUtil;
import org.example.views.CustomersView;
import java.awt.event.ActionListener;

public class CustomersController
    implements Controller
{
    private CustomersView customersView;
    private CustomersService customersService;

    public CustomersController(CustomersView customersView, CustomersService customersService)
    {
        this.customersView = customersView;
        this.customersService = customersService;

        loadCustomersData();

    }
    public void loadCustomersData()
    {
        var customers = customersService.getAllCustomers();
        customersView.displayCustomers(customers);
    }

    public CustomersView getCustomersView() {
        return customersView;
    }

    public CustomersService getCustomersService() {
        return customersService;
    }
}
