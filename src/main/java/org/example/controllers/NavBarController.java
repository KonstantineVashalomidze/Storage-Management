package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import org.example.util.DatabaseUtil;
import org.example.views.NavBar;
import org.example.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class NavBarController implements Controller {
    private NavBar navBar;
    private JFrame currentWindow;

    public NavBarController(NavBar navBar, JFrame currentWindow) {
        this.navBar = navBar;
        this.currentWindow = currentWindow;

        navBar.getPageDropdown().addActionListener(pageSelectionListener());
        navBar.getSearchField().addActionListener(searchFieldAct());
        navBar.getChartsButton().addActionListener(chartsButtonListener());
    }

    private ActionListener searchFieldAct() {
        return (e) -> {
            String searchTerm = navBar.getSearchField().getText(); // Get the search term from the text field

            if (currentWindow instanceof InventoryView inventoryView) {
                List<Product> products = DatabaseUtil.getInstance().searchProducts(searchTerm);
                inventoryView.displayItems(products);
            } else if (currentWindow instanceof CustomersView customersView) {
                List<Customer> customers = DatabaseUtil.getInstance().searchCustomers(searchTerm);
                customersView.displayCustomers(customers);
            } else if (currentWindow instanceof PurchasesView purchasesView) {
                List<Purchase> purchases = DatabaseUtil.getInstance().searchPurchases(searchTerm);
                purchasesView.displayPurchases(purchases);
            } else if (currentWindow instanceof SuppliersView suppliersView) {
                List<Supplier> suppliers = DatabaseUtil.getInstance().searchSuppliers(searchTerm);
                suppliersView.displaySuppliers(suppliers);
            } else if (currentWindow instanceof TransactionsView transactionsView) {
                List<Transaction> transactions = DatabaseUtil.getInstance().searchTransactions(searchTerm);
                transactionsView.displayTransactions(transactions);
            } else if (currentWindow instanceof UsersView usersView) {
                List<User> users = DatabaseUtil.getInstance().searchUsers(searchTerm);
                usersView.displayUsers(users);
            }
        };
    }

    private ActionListener chartsButtonListener()
    {
        return (e) ->
        {
            EventQueue.invokeLater(ChartSelectionView::new);
        };
    }


    private ActionListener pageSelectionListener() {
        return e -> {
            JComboBox<String> cb = (JComboBox<String>) e.getSource();
            String selectedPage = (String) cb.getSelectedItem();
            switch (Objects.requireNonNull(selectedPage)) {
                case "Inventory" -> openInventoryView();
                case "Customers" -> openCustomersView();
                case "Suppliers" -> openSuppliersView();
                case "Purchases" -> openPurchasesView();
                case "Transactions" -> openTransactionsView();
                case "Users" -> openUsersView();
                default -> {
                }
                // Handle default case or error
            }
        };
    }

    // Methods to open different views
    private void openInventoryView() {
        if (!currentWindow.getClass().getSimpleName().equals("InventoryView")) {
            EventQueue.invokeLater(() -> {
                var inventoryView = new InventoryView();
                var inventoryService = new InventoryService();
                var inventoryController = new InventoryController(inventoryView, inventoryService);
                destroyParentWindow();
            });
        }
    }

    private void openCustomersView() {
        if (!currentWindow.getClass().getSimpleName().equals("CustomersView")) {
            EventQueue.invokeLater(() -> {
                var customersView = new CustomersView();
                var customersService = new CustomersService();
                var customersController = new CustomersController(customersView, customersService);
                destroyParentWindow();
            });
        }
    }

    private void openSuppliersView() {
        if (!currentWindow.getClass().getSimpleName().equals("SuppliersView")) {
            EventQueue.invokeLater(() -> {
                var suppliersView = new SuppliersView();
                var suppliersService = new SuppliersService();
                var suppliersController = new SuppliersController(suppliersView, suppliersService);
                destroyParentWindow();
            });
        }
    }

    private void openPurchasesView() {
        if (!currentWindow.getClass().getSimpleName().equals("PurchasesView")) {
            EventQueue.invokeLater(() -> {
                var purchasesView = new PurchasesView();
                var purchasesService = new PurchasesService();
                var purchasesController = new PurchasesController(purchasesView, purchasesService);
                destroyParentWindow();
            });
        }
    }

    private void openTransactionsView() {
        if (!currentWindow.getClass().getSimpleName().equals("TransactionsView")) {
            EventQueue.invokeLater(() -> {
                var transactionsView = new TransactionsView();
                var transactionsService = new TransactionsService();
                var transactionsController = new TransactionsController(transactionsView, transactionsService);
                destroyParentWindow();
            });
        }
    }

    private void openUsersView() {
        if (!currentWindow.getClass().getSimpleName().equals("UsersView")) {
            EventQueue.invokeLater(() -> {
                var usersView = new UsersView();
                var usersService = new UsersService();
                var usersController = new UsersController(usersView, usersService);
                destroyParentWindow();
            });
        }
    }

    private void destroyParentWindow() {
        currentWindow.dispose();
    }
}
