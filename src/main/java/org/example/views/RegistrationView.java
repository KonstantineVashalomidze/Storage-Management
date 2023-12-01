package org.example.views;

import org.example.models.User;
import org.example.services.AuthenticationService;
import org.example.util.DatabaseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrationView extends JFrame {
    private JTextField usernameField, userIdField, emailField, nameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JComboBox<String> roleComboBox;

    private JButton registerButton, loginButton;

    public RegistrationView() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 350));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        addTextFieldWithLabel("Username:", usernameField = new JTextField(), panel);
        addPasswordFieldWithLabel("Password:", passwordField = new JPasswordField(), panel);
        addPasswordFieldWithLabel("Confirm Password:", confirmPasswordField = new JPasswordField(), panel);
        addTextFieldWithLabel("User ID:", userIdField = new JTextField(), panel);
        addTextFieldWithLabel("Email:", emailField = new JTextField(), panel);
        addTextFieldWithLabel("Name:", nameField = new JTextField(), panel);

        // Role selection
        panel.add(new JLabel("Role:"));
        String[] roles = {"Admin", "Manager", "Staff"};
        roleComboBox = new JComboBox<>(roles);
        panel.add(roleComboBox);

        // Register and Clear buttons
        registerButton = new JButton("Register");
        panel.add(registerButton);

        JButton cancelButton = new JButton("Clear");
        cancelButton.addActionListener(e -> clearFields());
        panel.add(cancelButton);

        // Add the Login button
        loginButton = createLoginButton();
        panel.add(loginButton);

        // Exit Button
        JButton exitButton = createExitButton();
        panel.add(exitButton);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // A method to create button for exit from the window
    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> dispose());
        return exitButton;
    }

    // Add a method to create a button for navigating to the LoginView
    private JButton createLoginButton() {
        return new JButton("Back to Login");
    }



    // Getter methods for RegistrationController
    public JButton getLoginButton()
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

    public String getUserId() {
        return userIdField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getName() {
        return nameField.getText();
    }

    public String getSelectedRole() {
        return (String) roleComboBox.getSelectedItem();
    }


    public void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        userIdField.setText("");
        emailField.setText("");
        nameField.setText("");
        roleComboBox.setSelectedIndex(0);
    }

    private void addTextFieldWithLabel(String labelText, JTextField textField, JPanel panel) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(textField);
    }

    private void addPasswordFieldWithLabel(String labelText, JPasswordField passwordField, JPanel panel) {
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(passwordField);
    }


    public JButton getRegisterButton() {
        return registerButton;
    }
}
