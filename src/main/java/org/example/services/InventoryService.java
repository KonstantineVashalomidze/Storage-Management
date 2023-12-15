package org.example.services;

import org.example.models.Product;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    // Assuming inventory is stored as a list in memory
    private List<Product> inventory;

    public InventoryService() {
        // Initialize inventory or retrieve it from a database or file
        this.inventory = new ArrayList<>();
        // Load inventory from the database into memory upon service initialization
        loadInventoryFromDatabase();
    }

    public List<Product> getAllProducts() {
        return this.inventory;
    }

    public void addProduct(Product newProduct) {

    }

    public void removeProduct(Product product) {

    }

    public Product getProductAtIndex(int index)
    {
        return this.inventory.get(index);
    }

    public void updateProduct(Product updatedProduct) {
        // Find the product in the inventory and update its details

    }


    // Method to load inventory from the database into memory
    private void loadInventoryFromDatabase() {
        inventory = DatabaseUtil.getInstance().getAllTheProduct();
    }

}