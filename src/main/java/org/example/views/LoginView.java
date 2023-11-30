package org.example.views;

import org.example.models.User;
import org.example.services.AuthenticationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private AuthenticationService authService;

    public LoginView(AuthenticationService authService) {
        this.authService = authService;

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 250));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            // Handle login button click event
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            User authenticatedUser = authService.authenticate(username, password);

            if (authenticatedUser != null) {
                // Authentication successful
                JOptionPane.showMessageDialog(this, "Login Successful!");
                // Add logic to proceed after successful login (e.g., open main dashboard)
                new DashboardView().setVisible(true);
                this.dispose();
            } else {
                // Authentication failed
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
                // clear the password field
                passwordField.setText("");
            }


        });
        panel.add(loginButton);

        JButton cancelButton = new JButton("Clear");
        cancelButton.addActionListener(e -> {
            // Handle cancel button click event
            usernameField.setText("");
            passwordField.setText("");
        });
        panel.add(cancelButton);

        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the JFrame on screen
        setVisible(true);
    }


    public JButton getLoginButton() {
        // Returns the login button
        return (JButton) getContentPane().getComponent(4);
    }

    public String getUsername() {
        // Returns the text entered in the username field
        return usernameField.getText();
    }

    public String getPassword() {
        // Returns the text entered in the password field
        return new String(passwordField.getPassword());
    }

}
