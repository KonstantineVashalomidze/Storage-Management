package org.example.services;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.models.User;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class UsersService {
    private List<User> users;

    public UsersService() {
        this.users = new ArrayList<>();
        loadUsersFromDatabase();
    }

    public List<User> getAllUsers() {
        return this.users;
    }


    public User getUserAtIndex(int index)
    {
        return this.users.get(index);
    }

    public void updateCustomer(Customer customer) {
        // Find the product in the inventory and update its details

    }


    // Method to load inventory from the database into memory
    private void loadUsersFromDatabase() {
        this.users = DatabaseUtil.getInstance().getAllTheUsers();
    }
}
