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

        loadSuppliersData();

    }
    public void loadSuppliersData()
    {
        var suppliers = suppliersService.getAllSuppliers();
        suppliersView.displaySuppliers(suppliers);
    }

    public SuppliersView getSuppliersView() {
        return suppliersView;
    }

    public SuppliersService getSuppliersService() {
        return suppliersService;
    }
}
