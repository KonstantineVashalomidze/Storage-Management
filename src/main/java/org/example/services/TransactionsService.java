package org.example.services;

import org.example.models.Purchase;
import org.example.models.Transaction;
import org.example.util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class TransactionsService {
    private List<Transaction> transactions;

    public TransactionsService() {
        this.transactions = new ArrayList<>();
        loadTransactionsFromDatabase();
    }

    public List<Transaction> getAllTransactions() {
        return this.transactions;
    }

    public void addTransaction(Transaction newTransaction) {

    }

    public void removeTransaction(Transaction transaction) {

    }

    public Transaction getTransactionAtIndex(int index)
    {
        return this.transactions.get(index);
    }

    public void updateTransaction(Transaction updatedTransaction) {
        // Find the product in the inventory and update its details

    }


    // Method to load inventory from the database into memory
    private void loadTransactionsFromDatabase() {
        this.transactions = DatabaseUtil.getInstance().getAllTheTransactions();
    }
}
