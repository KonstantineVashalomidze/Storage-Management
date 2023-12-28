package org.example.controllers;

import org.example.models.Customer;
import org.example.models.Purchase;
import org.example.services.CustomersService;
import org.example.services.PurchasesService;
import org.example.util.DatabaseUtil;
import org.example.views.CustomersView;
import org.example.views.PurchasesView;

import java.awt.event.ActionListener;

public class PurchasesController
    implements Controller
{

    private PurchasesView purchasesView;
    private PurchasesService purchaseService;

    public PurchasesController(PurchasesView purchasesView, PurchasesService purchasesService)
    {
        this.purchasesView = purchasesView;
        this.purchaseService = purchasesService;

        // Attach listeners to UI components
        this.purchasesView.getAddButton().addActionListener(onAddClk());
        this.purchasesView.getRemoveButton().addActionListener(onRemoveClk());

        loadPurchasesData();

    }
    public void loadPurchasesData()
    {
        var purchases = purchaseService.getAllPurchases();
        purchasesView.displayPurchases(purchases);
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
            Purchase selectedPurchase = purchaseService.getPurchaseAtIndex(purchasesView.getSelectedPurchaseIndex());

            // Remove the item via the service
            purchaseService.removePurchase(selectedPurchase);

            // reload the data form database
            loadPurchasesData();
        };
    }

    public PurchasesView getPurchasesView() {
        return purchasesView;
    }

    public PurchasesService getPurchaseService() {
        return purchaseService;
    }
}
