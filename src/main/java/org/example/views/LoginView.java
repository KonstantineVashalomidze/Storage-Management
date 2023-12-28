package org.example.views;

import org.example.views.view_components.BetterButton;
import org.example.views.view_components.BetterLabel;
import org.example.views.view_components.BetterPasswordField;
import org.example.views.view_components.BetterTextField;

import javax.swing.*;
import java.awt.*;


public class LoginView extends JFrame {
    private BetterTextField usernameField;
    private BetterPasswordField passwordField;

    private BetterButton loginButton, registrationButton;

    public LoginView() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 250));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        BetterLabel usernameLabel = new BetterLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new BetterTextField();
        panel.add(usernameField);

        BetterLabel passwordLabel = new BetterLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new BetterPasswordField();
        panel.add(passwordField);

        loginButton = new BetterButton("Login");
        panel.add(loginButton);

        BetterButton cancelButton = new BetterButton("Clear");
        cancelButton.addActionListener(e -> {
            // Handle cancel button click event
            usernameField.setText("");
            passwordField.setText("");
        });
        panel.add(cancelButton);

        registrationButton = createRegisterButton();
        panel.add(registrationButton);

        BetterButton exitButton = createExitButton();
        panel.add(exitButton);


        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on screen
        setVisible(true);
    }

    // A method to create button for exit from the window
    private BetterButton createExitButton() {
        BetterButton exitButton = new BetterButton("Exit");
        exitButton.addActionListener(e -> dispose());
        return exitButton;
    }

    // Add a method to create a button for navigating to the LoginView
    private BetterButton createRegisterButton() {
        return new BetterButton("Back to Registration");
    }



    public BetterButton getRegistrationButton() {
        return registrationButton;
    }

    public BetterButton getLoginButton() {
        // Returns the login button
        return loginButton;
    }

    public BetterTextField getUsername() {
        // Returns the text entered the username field
        return usernameField;
    }

    public BetterPasswordField getPassword() {
        // Returns the text entered the password field
        return passwordField;
    }

}
