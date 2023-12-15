package org.example.services;

import org.example.models.Supplier;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class SuppliersService
{

    private List<Supplier> suppliers;

    public SuppliersService() {
        this.suppliers = new ArrayList<>();
        loadSuppliersFromDatabase();
    }

    public List<Supplier> getAllSuppliers() {
        return this.suppliers;
    }

    public void addSupplier(Supplier newSupplier) {

    }

    public void removeSupplier(Supplier supplier) {

    }

    public Supplier getSupplierAtIndex(int index)
    {
        return this.suppliers.get(index);
    }

    public void updateSupplier(Supplier updatedSupplier)
    {
        // Find the product in the inventory and update its details
    }

    // Method to load inventory from the database into memory
    private void loadSuppliersFromDatabase()
    {
        this.suppliers = DatabaseUtil.getInstance().getAllTheSuppliers();
    }

}
