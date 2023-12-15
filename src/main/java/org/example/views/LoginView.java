package org.example.views;

import javax.swing.*;
import java.awt.*;


public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton loginButton, registrationButton;

    public LoginView() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 250));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(loginButton);

        JButton cancelButton = new JButton("Clear");
        cancelButton.addActionListener(e -> {
            // Handle cancel button click event
            usernameField.setText("");
            passwordField.setText("");
        });
        panel.add(cancelButton);

        registrationButton = createRegisterButton();
        panel.add(registrationButton);

        JButton exitButton = createExitButton();
        panel.add(exitButton);


        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on screen
        setVisible(true);
    }

    // A method to create button for exit from the window
    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> dispose());
        return exitButton;
    }

    // Add a method to create a button for navigating to the LoginView
    private JButton createRegisterButton() {
        return new JButton("Back to Registration");
    }



    public JButton getRegistrationButton() {
        return registrationButton;
    }

    public JButton getLoginButton() {
        // Returns the login button
        return loginButton;
    }

    public JTextField getUsername() {
        // Returns the text entered the username field
        return usernameField;
    }

    public JPasswordField getPassword() {
        // Returns the text entered the password field
        return passwordField;
    }

}
