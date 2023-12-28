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


        loadTransactionsData();

    }
    public void loadTransactionsData()
    {
        var transactions = transactionsService.getAllTransactions();
        transactionsView.displayTransactions(transactions);
    }


    public TransactionsView getTransactionsView() {
        return transactionsView;
    }

    public TransactionsService getTransactionsService() {
        return transactionsService;
    }
}
