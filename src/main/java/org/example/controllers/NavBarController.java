package org.example.controllers;

import org.example.models.User;
import org.example.services.*;
import org.example.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class NavBarController implements Controller {
    private NavBar navBar;
    private JFrame currentWindow;

    public NavBarController(NavBar navBar, JFrame currentWindow) {
        this.navBar = navBar;
        this.currentWindow = currentWindow;

        navBar.getInventoryBtn().addActionListener(inventoryClk());
        navBar.getCustomersBtn().addActionListener(customersClk());
        navBar.getSuppliersBtn().addActionListener(suppliersClk());
        navBar.getPurchaseBtn().addActionListener(purchaseClk());
        navBar.getTransactionsBtn().addActionListener(transactionsClk());
        navBar.getUsersBtn().addActionListener(usersClk());
    }




    private void destroyParentWindow()
    {
        currentWindow.dispose();
    }

    private ActionListener inventoryClk()
    {
        return (e) -> {
            if (!currentWindow.getClass().getSimpleName().equals("InventoryView"))
            {
                EventQueue.invokeLater(() -> {
                    var inventoryView = new InventoryView();
                    var inventoryService = new InventoryService();
                    var inventoryController = new InventoryController(inventoryView, inventoryService);
                    destroyParentWindow();

                });
            }
        };
    }

    private ActionListener customersClk()
    {
        return (e) -> {
          if (!currentWindow.getClass().getSimpleName().equals("CustomersView"))
          {
              EventQueue.invokeLater(() -> {
                 var customersView = new CustomersView();
                 var customersService = new CustomersService();
                 var customersController = new CustomersController(customersView, customersService);
                 destroyParentWindow();
              });
          }
        };
    }



    private ActionListener suppliersClk()
    {
        return (e) -> {
            if (!currentWindow.getClass().getSimpleName().equals("SuppliersView"))
            {
                EventQueue.invokeLater(() -> {
                    var suppliersView = new SuppliersView();
                    var suppliersService = new SuppliersService();
                    var suppliersController = new SuppliersController(suppliersView, suppliersService);
                    destroyParentWindow();
                });
            }
        };
    }


    private ActionListener purchaseClk()
    {
        return (e) -> {
            if (!currentWindow.getClass().getSimpleName().equals("PurchasesView"))
            {
                EventQueue.invokeLater(() -> {
                   var purchasesView = new PurchasesView();
                   var purchasesService = new PurchasesService();
                   var purchasesController = new PurchasesController(purchasesView, purchasesService);
                   destroyParentWindow();
                });
            }
        };
    }

    private ActionListener transactionsClk()
    {
        return (e) -> {
          if (!currentWindow.getClass().getSimpleName().equals("TransactionsView")){
              EventQueue.invokeLater(() -> {
                  var transactionsView = new TransactionsView();
                  var transactionsService = new TransactionsService();
                  var transactionsController = new TransactionsController(transactionsView, transactionsService);
                  destroyParentWindow();
              });
          }
        };
    }


    private ActionListener usersClk() {
        return (e) -> {
            if (!currentWindow.getClass().getSimpleName().equals("UsersView"))
            {
                EventQueue.invokeLater(() -> {
                    var usersView = new UsersView();
                    var usersService = new UsersService();
                    var usersController = new UsersController(usersView, usersService);
                    destroyParentWindow();
                });
            }
        };
    }


}
