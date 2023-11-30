package org.example.controllers;



import org.example.models.User;
import org.example.services.AuthenticationService;
import org.example.views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private final LoginView loginView;
    private final AuthenticationService authService;

    public LoginController(LoginView loginView, AuthenticationService authService) {
        this.loginView = loginView;
        this.authService = authService;

        attachLoginActionListener();
    }

    private void attachLoginActionListener() {
        loginView.getLoginButton().addActionListener(e -> {
            String username = loginView.getUsername();
            String password = loginView.getPassword();

            User user = authService.authenticate(username, password);

            if (user != null) {
                // Successful login, navigate to dashboard or respective screen
                JOptionPane.showMessageDialog(loginView, "Login successful!");
                // Navigate to DashboardView or appropriate screen
            } else {
                // Invalid credentials, display error message
                JOptionPane.showMessageDialog(loginView, "Invalid username or password. Please try again.");
            }
        });
    }

    // You can include additional methods for handling other login-related functionalities or validations.
}
