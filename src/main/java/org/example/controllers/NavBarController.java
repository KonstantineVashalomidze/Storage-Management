package org.example.controllers;

import org.example.models.User;
import org.example.services.AuthenticationService;
import org.example.services.CustomersService;
import org.example.services.InventoryService;
import org.example.services.SuppliersService;
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
        navBar.getLoginButton().addActionListener(loginClk());
        navBar.getRegistrationButton().addActionListener(registrationClk());
        navBar.getCustomers().addActionListener(customersClk());
        navBar.getSuppliers().addActionListener(suppliersClk());
    }

    private void destroyParentWindow()
    {
        currentWindow.dispose();
    }

    private ActionListener registrationClk() {
        return (e) -> {

            if (!currentWindow.getClass().getSimpleName().equals("RegistrationView"))
            {
                EventQueue.invokeLater(() -> {
                    var registrationView = new RegistrationView();
                    var registrationController = new RegistrationController(registrationView);
                    destroyParentWindow();
                });
            }
        };
    }

    private ActionListener loginClk() {
        return (e) -> {
            if (!currentWindow.getClass().getSimpleName().equals("LoginView"))
            {
                EventQueue.invokeLater(() -> {
                    var loginView = new LoginView();
                    var loginController = new LoginController(loginView, AuthenticationService.getInstance());
                    destroyParentWindow();

                });
            }
        };
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



}
