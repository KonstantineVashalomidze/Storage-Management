package org.example.services;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomersService
{
    private List<Customer> customers;

    public CustomersService() {
        this.customers = new ArrayList<>();
        loadCustomersFromDatabase();
    }

    public List<Customer> getAllCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer newCustomer) {

    }

    public void removeCustomer(Customer customer) {

    }

    public Customer getCustomerAtIndex(int index)
    {
        return this.customers.get(index);
    }

    public void updateCustomer(Customer customer) {
        // Find the product in the inventory and update its details

    }


    // Method to load inventory from the database into memory
    private void loadCustomersFromDatabase() {
        this.customers = DatabaseUtil.getInstance().getAllTheCustomers();
    }
}
