package org.example.controllers;



import org.example.models.User;
import org.example.services.AuthenticationService;
import org.example.views.LoginView;
import org.example.views.RegistrationView;

import javax.swing.*;
import java.awt.*;

public class LoginController {
    private final LoginView loginView;
    private final AuthenticationService authService;

    public LoginController(LoginView loginView, AuthenticationService authService) {
        this.loginView = loginView;
        this.authService = authService;

        attachLoginActionListener();
        attachRegisterActionListener();
    }

    private void attachRegisterActionListener()
    {
        loginView.getRegistrationButton().addActionListener(e -> {
            openRegisterView();
            loginView.dispose();
        });
    }


    private void attachLoginActionListener() {

        loginView.getLoginButton().addActionListener(e -> {
            // Handle login button click event
            String username = loginView.getUsername().getText();
            String password = new String(loginView.getPassword().getPassword());

            User authenticatedUser = authService.authenticate(username, password);

            if (authenticatedUser != null) {
                // Authentication successful
                JOptionPane.showMessageDialog(loginView, "Login Successful!");
                // Add logic to proceed after successful login (e.g., open main dashboard)
                new DashboardController(authenticatedUser);
                loginView.dispose();
            } else {
                // Authentication failed
                JOptionPane.showMessageDialog(loginView, "Invalid username or password. Please try again.");
                // clear the password field
                loginView.getPassword().setText("");
            }
        });

    }


    // Method to open the LoginView
    private void openRegisterView() {

        EventQueue.invokeLater(() -> {
            RegistrationView registrationView = new RegistrationView(); // Create an instance of registrationView
            registrationView.setVisible(true); // Display the registrationView
            RegistrationController registrationController = new RegistrationController(registrationView, authService);
        });
    }


    // You can include additional methods for handling other login-related functionalities or validations.
}
