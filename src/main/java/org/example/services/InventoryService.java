package org.example.services;

import org.example.models.Item;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private List<Item> inventory; // Assuming inventory is stored as a list

    public InventoryService() {
        // Initialize inventory or retrieve it from a database or file
        this.inventory = new ArrayList<>();
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
        // Additional logic to persist the added item to the database or file
    }

    public void removeItem(Item selectedItem) {
        this.inventory.remove(selectedItem);
        // Additional logic to update the database or file after removing the item
    }

    public void updateItem(Item updatedItem) {
        // Find the item in the inventory and update its details
        for (Item item : this.inventory) {
            if (item.getItemId().equals(updatedItem.getItemId())) { // Assuming each item has an ID
                // Update the item details
                item.setName(updatedItem.getItemName());
                item.setDescription(updatedItem.getDescription());
                item.setQuantity(updatedItem.getQuantity());
                item.setPrice(updatedItem.getPrice());
                // Additional logic to persist the updated item to the database or file
                break;
            }
        }
    }
}
