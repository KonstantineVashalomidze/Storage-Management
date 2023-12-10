package org.example.controllers;

import org.example.models.User;
import org.example.services.AuthenticationService;
import org.example.views.LoginView;
import org.example.views.RegistrationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrationController {
    private final RegistrationView registrationView;
    private final AuthenticationService authService;

    public RegistrationController(RegistrationView registrationView, AuthenticationService authService) {
        this.registrationView = registrationView;
        this.authService = authService;

        attachRegisterActionListener();
        attachLoginActionListener();
    }

    private void attachRegisterActionListener() {
        registrationView.getRegisterButton().addActionListener(e -> {
            boolean registrationSuccess = onRegisterButtonClick(e);
            if (registrationSuccess)
            {
                openLoginView();
                registrationView.dispose(); // Close the current RegistrationView window
            }
            else
            {
                registrationView.clearFields();
            }
        });
    }

    private void attachLoginActionListener()
    {
        registrationView.getLoginButton().addActionListener(e -> {
                openLoginView();
                registrationView.dispose(); // Close the current RegistrationView window
                     });
    }


    // Method to open the LoginView
    private void openLoginView() {
        EventQueue.invokeLater(() ->
        {
            LoginView loginView = new LoginView(); // Create an instance of LoginView
            loginView.setVisible(true); // Display the LoginView
            LoginController loginController = new LoginController(loginView, authService);
        });
    }

    private boolean onRegisterButtonClick(ActionEvent e) {
        String username = registrationView.getUsername();
        String password = registrationView.getPassword();
        String confirmPassword = registrationView.getConfirmPassword();
        String role = registrationView.getSelectedRole();

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(registrationView, "Passwords do not match!");
            return false;
        }

        // Create a new User object with the provided details
        User newUser = new User(username, role, password);

        // Add logic to save the user using the AuthenticationService (not implemented in this example)
        boolean registrationSuccess = authService.registerUser(newUser);

        if (registrationSuccess) {
            JOptionPane.showMessageDialog(registrationView, "Registration Successful!");
            registrationView.clearFields();
        } else {
            JOptionPane.showMessageDialog(registrationView, "Failed to register user. Please try again.");
        }
        return registrationSuccess;
    }
}
