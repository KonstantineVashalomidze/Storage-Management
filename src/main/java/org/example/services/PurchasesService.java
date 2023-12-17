package org.example.services;

import org.example.models.Customer;
import org.example.models.Product;
import org.example.models.Purchase;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class PurchasesService {
    private List<Purchase> purchases;

    public PurchasesService() {
        this.purchases = new ArrayList<>();
        loadPurchasesFromDatabase();
    }

    public List<Purchase> getAllPurchases() {
        return this.purchases;
    }

    public void addPurchase(Purchase newPurchase) {

    }

    public void removePurchase(Purchase purchase) {

    }

    public Purchase getPurchaseAtIndex(int index)
    {
        return this.purchases.get(index);
    }

    public void updatePurchase(Purchase updatedPurchase) {
        // Find the product in the inventory and update its details

    }


    // Method to load inventory from the database into memory
    private void loadPurchasesFromDatabase() {
        this.purchases = DatabaseUtil.getInstance().getAllThePurchases();
    }
}
