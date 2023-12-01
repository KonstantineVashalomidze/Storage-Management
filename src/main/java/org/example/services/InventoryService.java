package org.example.services;

import org.example.models.Item;
import org.example.models.User;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    // Assuming inventory is stored as a list in memory
    private List<Item> inventory;

    public InventoryService() {
        // Initialize inventory or retrieve it from a database or file
        this.inventory = new ArrayList<>();
        // Load inventory from the database into memory upon service initialization
        loadInventoryFromDatabase();
    }

    public List<Item> getInventory(User currentUser) {
        // Return inventory based on user access rights, if needed
        // For simplicity, returning the whole inventory
        return this.inventory;
    }

    public List<Item> getAllItems() {
        return this.inventory;
    }

    public void addItem(Item newItem) {
        this.inventory.add(newItem);
        // Persist the added item to the database
        DatabaseUtil.getInstance().addItemToDatabase(newItem);
    }

    public void removeItem(Item itemName) {
        this.inventory.remove(itemName);
        // Update the database after removing the item
        DatabaseUtil.getInstance().removeItemFromDatabase(itemName);
    }

    public void updateItem(Item updatedItem) {
        // Find the item in the inventory and update its details
        for (Item item : this.inventory) {
            if (item.getItemId().equals(updatedItem.getItemId())) { // Assuming each item has an ID
                // Update the item details
                item.setName(updatedItem.getItemName());
                item.setDescription(updatedItem.getDescription());
                item.setQuantity(updatedItem.getQuantity());
                item.setPrice(Double.parseDouble(String.valueOf(updatedItem.getPrice())));
                // Additional logic to persist the updated item to the database
                // This logic could involve updating the existing item details in the database
                break;
            }
        }
    }

    // Method to load inventory from the database into memory
    private void loadInventoryFromDatabase() {
        // Retrieve inventory items from the database using DatabaseUtil and add them to the inventory list
        // For example:
        // List<Item> itemsFromDatabase = DatabaseUtil.getAllItemsFromDatabase();
        // this.inventory.addAll(itemsFromDatabase);

        // Retrieve inventory items from the database using DatabaseUtil and add them to the inventory list
        try {
            List<Item> itemsFromDatabase = DatabaseUtil.getInstance().getAllItemsFromDatabase();
            this.inventory.addAll(itemsFromDatabase);
            System.out.println("Inventory loaded from the database.");
        } catch (Exception e) {
            System.out.println("Error loading inventory from the database: " + e.getMessage());
        }

    }

}