package org.example.controllers;

import org.example.models.Purchase;
import org.example.models.Transaction;
import org.example.services.PurchasesService;
import org.example.services.TransactionsService;
import org.example.views.PurchasesView;
import org.example.views.TransactionsView;

import java.awt.event.ActionListener;

public class TransactionsController implements Controller {

    private TransactionsView transactionsView;
    private TransactionsService transactionsService;

    public TransactionsController(TransactionsView transactionsView, TransactionsService transactionsService)
    {
        this.transactionsView = transactionsView;
        this.transactionsService = transactionsService;

        // Attach listeners to UI components
        this.transactionsView.getAddButton().addActionListener(onAddClk());
        this.transactionsView.getRemoveButton().addActionListener(onRemoveClk());

        loadTransactionsData();

    }
    public void loadTransactionsData()
    {
        var transactions = transactionsService.getAllTransactions();
        transactionsView.displayTransactions(transactions);
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
            Transaction selectedTransaction = transactionsService.getTransactionAtIndex(transactionsView.getSelectedTransactionIndex());

            // Remove the item via the service
            transactionsService.removeTransaction(selectedTransaction);

            // reload the data form database
            loadTransactionsData();
        };
    }



}
