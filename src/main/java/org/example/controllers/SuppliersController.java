package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Supplier;
import org.example.services.SuppliersService;
import org.example.util.DatabaseUtil;
import org.example.views.SuppliersView;

import java.awt.event.ActionListener;

public class SuppliersController
    implements Controller
{
    private SuppliersView suppliersView;
    private SuppliersService suppliersService;

    public SuppliersController(SuppliersView suppliersView, SuppliersService suppliersService)
    {
        this.suppliersView = suppliersView;
        this.suppliersService = suppliersService;

        // Attach listeners to UI components
        this.suppliersView.getAddButton().addActionListener(onAddClk());
        this.suppliersView.getRemoveButton().addActionListener(onRemoveClk());

        loadSuppliersData();

    }
    public void loadSuppliersData()
    {
        var suppliers = suppliersService.getAllSuppliers();
        suppliersView.displaySuppliers(suppliers);
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
            Supplier selectedSupplier = suppliersService.getSupplierAtIndex(suppliersView.getSelectedSupplierIndex());

            // Remove the item via the service
            suppliersService.removeSupplier(selectedSupplier);

            // reload the data form database
            loadSuppliersData();
        };
    }



}
