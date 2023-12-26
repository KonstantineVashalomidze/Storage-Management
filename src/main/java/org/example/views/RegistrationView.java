package org.example.views;


import org.example.views.view_components.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrationView extends BetterFrame {
    private BetterTextField usernameField;
    private BetterPasswordField passwordField, confirmPasswordField;
    private BetterComboBox<String> roleComboBox;

    private BetterButton registerButton, loginButton;

    public RegistrationView() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 350));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        addTextFieldWithLabel("Username:", usernameField = new BetterTextField(), panel);
        addPasswordFieldWithLabel("Password:", passwordField = new BetterPasswordField(), panel);
        addPasswordFieldWithLabel("Confirm Password:", confirmPasswordField = new BetterPasswordField(), panel);

        // Role selection
        panel.add(new JLabel("Role:"));
        String[] roles = {"Admin", "Manager", "Staff"};
        roleComboBox = new BetterComboBox<>(roles);
        panel.add(roleComboBox);

        // Register and Clear buttons
        registerButton = new BetterButton("Register");
        panel.add(registerButton);

        BetterButton cancelButton = new BetterButton("Clear");
        cancelButton.addActionListener(e -> clearFields());
        panel.add(cancelButton);

        // Add the Login button
        loginButton = createLoginButton();
        panel.add(loginButton);

        // Exit Button
        BetterButton exitButton = createExitButton();
        panel.add(exitButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // A method to create button for exit from the window
    private BetterButton createExitButton() {
        BetterButton exitButton = new BetterButton("Exit");
        exitButton.addActionListener(e -> dispose());
        return exitButton;
    }

    // Add a method to create a button for navigating to the LoginView
    private BetterButton createLoginButton() {
        return new BetterButton("Back to Login");
    }



    // Getter methods for RegistrationController
    public BetterButton getLoginButton()
    {
        return loginButton;
    }


    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getConfirmPassword() {
        return new String(confirmPasswordField.getPassword());
    }





    public String getSelectedRole() {
        return (String) roleComboBox.getSelectedItem();
    }


    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        roleComboBox.setSelectedIndex(0);
    }

    private void addTextFieldWithLabel(String labelText, BetterTextField textField, JPanel panel) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(textField);
    }

    private void addPasswordFieldWithLabel(String labelText, BetterPasswordField passwordField, JPanel panel) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(passwordField);
    }


    public BetterButton getRegisterButton() {
        return registerButton;
    }
}
