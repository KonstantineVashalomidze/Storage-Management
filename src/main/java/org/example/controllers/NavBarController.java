package org.example.controllers;

import org.example.models.*;
import org.example.services.*;
import org.example.util.DatabaseUtil;
import org.example.views.NavBar;
import org.example.views.*;
import org.example.views.configurations.JFrameConfigurations;
import org.example.views.view_components.BetterComboBox;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class NavBarController implements Controller {
    private NavBar navBar;
    private MainWindow mainWindow;
    // inventoryController, customersController, suppliersController, purchasesController, transactionsController, usersController
    private List<Controller> pageControllers;

    private ChartSelectionView chartWindow;
    private JPanel currentPage;

    // indicates if the window is full screen
    boolean isFullScreen = false;



    public NavBarController(NavBar navBar, MainWindow mainWindow) {
        this.navBar = navBar;
        this.mainWindow = mainWindow;
        // construct pages
        createPages();

        // set current page and title to inventory view
        currentPage = ((InventoryController) pageControllers.get(0)).getInventoryView();
        mainWindow.setWindowTitle("Inventory Management");

        // initially set Inventory view as main page
        mainWindow.setCurrentPage(currentPage);


        navBar.getPageDropdown().addActionListener(pageSelectionListener());
        navBar.getSearchField().addActionListener(searchFieldAct());
        navBar.getChartsButton().addActionListener(chartsButtonListener());
        navBar.getResizeButton().addActionListener(resizeButtonListener());
    }

    private ActionListener resizeButtonListener()
    {
        return e ->
                validateWindowSize(mainWindow);
    }

    private void validateWindowSize(JFrame mainWindow)
    {
        if (isFullScreen)
        {
            JFrameConfigurations.makeDefaultScreen(mainWindow);
            isFullScreen = false;
        }
        else
        {
            JFrameConfigurations.makeFullScreen(mainWindow);
            isFullScreen = true;
        }
    }

    private ActionListener searchFieldAct() {
        return (e) -> {
            String searchTerm = navBar.getSearchField().getText(); // Get the search term from the text field

            if (currentPage instanceof InventoryView inventoryView) {
                List<Product> products = DatabaseUtil.getInstance().searchProducts(searchTerm);
                inventoryView.displayItems(products);
            } else if (currentPage instanceof CustomersView customersView) {
                List<Customer> customers = DatabaseUtil.getInstance().searchCustomers(searchTerm);
                customersView.displayCustomers(customers);
            } else if (currentPage instanceof PurchasesView purchasesView) {
                List<Purchase> purchases = DatabaseUtil.getInstance().searchPurchases(searchTerm);
                purchasesView.displayPurchases(purchases);
            } else if (currentPage instanceof SuppliersView suppliersView) {
                List<Supplier> suppliers = DatabaseUtil.getInstance().searchSuppliers(searchTerm);
                suppliersView.displaySuppliers(suppliers);
            } else if (currentPage instanceof TransactionsView transactionsView) {
                List<Transaction> transactions = DatabaseUtil.getInstance().searchTransactions(searchTerm);
                transactionsView.displayTransactions(transactions);
            } else if (currentPage instanceof UsersView usersView) {
                List<User> users = DatabaseUtil.getInstance().searchUsers(searchTerm);
                usersView.displayUsers(users);
            }
        };
    }



    private void createPages()
    {
        // create inventory
        var inventoryView = new InventoryView();
        var inventoryService = new InventoryService();
        var inventoryController = new InventoryController(inventoryView, inventoryService);

        // create customers
        var customersView = new CustomersView();
        var customersService = new CustomersService();
        var customersController = new CustomersController(customersView, customersService);

        // create suppliers
        var suppliersView = new SuppliersView();
        var suppliersService = new SuppliersService();
        var suppliersController = new SuppliersController(suppliersView, suppliersService);

        // create purchases
        var purchasesView = new PurchasesView();
        var purchasesService = new PurchasesService();
        var purchasesController = new PurchasesController(purchasesView, purchasesService);

        // create transactions
        var transactionsView = new TransactionsView();
        var transactionsService = new TransactionsService();
        var transactionsController = new TransactionsController(transactionsView, transactionsService);

        // create users
        var usersView = new UsersView();
        var usersService = new UsersService();
        var usersController = new UsersController(usersView, usersService);


        pageControllers = List.of(inventoryController,
                customersController,
                suppliersController,
                purchasesController,
                transactionsController,
                usersController);
    }



    private ActionListener chartsButtonListener()
    {
        return (e) ->
        {
            EventQueue.invokeLater(() ->
            {
                chartWindow = new ChartSelectionView();
                validateWindowSize(chartWindow);
            });
        };
    }



    private ActionListener pageSelectionListener() {
        return e -> {
            BetterComboBox<String> cb = (BetterComboBox<String>) e.getSource();
            String selectedPage = (String) cb.getSelectedItem();
            switch (Objects.requireNonNull(selectedPage)) {
                case "Inventory" -> {
                    openInventoryView();
                }
                case "Customers" -> openCustomersView();
                case "Suppliers" -> openSuppliersView();
                case "Purchases" -> openPurchasesView();
                case "Transactions" -> openTransactionsView();
                case "Users" -> openUsersView();
                default ->
                {
                    // Handle default case or error
                }

            }
        };
    }


    // Methods to open different views
    private void openInventoryView() {
        if (!currentPage.getClass().getSimpleName().equals("InventoryView")) {
            currentPage = ((InventoryController) pageControllers.get(0)).getInventoryView();
            mainWindow.setWindowTitle("Inventory Management");
            mainWindow.setCurrentPage(currentPage);
        }
    }

    private void openCustomersView() {
        if (!currentPage.getClass().getSimpleName().equals("CustomersView")) {
            currentPage = ((CustomersController) pageControllers.get(1)).getCustomersView();
            mainWindow.setWindowTitle("Customer Management");
            mainWindow.setCurrentPage(currentPage);
        }
    }

    private void openSuppliersView() {
        if (!currentPage.getClass().getSimpleName().equals("SuppliersView")) {
            currentPage = ((SuppliersController) pageControllers.get(2)).getSuppliersView();
            mainWindow.setWindowTitle("Supplier Management");
            mainWindow.setCurrentPage(currentPage);
        }
    }

    private void openPurchasesView() {
        if (!currentPage.getClass().getSimpleName().equals("PurchasesView")) {
            currentPage = ((PurchasesController) pageControllers.get(3)).getPurchasesView();
            mainWindow.setWindowTitle("Purchase Management");
            mainWindow.setCurrentPage(currentPage);
        }
    }

    private void openTransactionsView() {
        if (!currentPage.getClass().getSimpleName().equals("TransactionsView")) {
            currentPage = ((TransactionsController) pageControllers.get(4)).getTransactionsView();
            mainWindow.setWindowTitle("Transaction Management");
            mainWindow.setCurrentPage(currentPage);
        }
    }

    private void openUsersView() {
        if (!currentPage.getClass().getSimpleName().equals("UsersView")) {
            currentPage = ((UsersController) pageControllers.get(5)).getUsersView();
            mainWindow.setWindowTitle("User Management");
            mainWindow.setCurrentPage(currentPage);
        }
    }


}
