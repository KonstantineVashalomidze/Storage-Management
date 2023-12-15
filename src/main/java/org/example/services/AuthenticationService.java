package org.example.services;

import org.example.models.User;
import org.example.util.DatabaseUtil;

public class AuthenticationService {
    private static volatile AuthenticationService instance;
    private DatabaseUtil databaseUtil;

    private AuthenticationService() {
        this.databaseUtil = DatabaseUtil.getInstance();
    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            synchronized (AuthenticationService.class) {
                if (instance == null) {
                    instance = new AuthenticationService();
                }
            }
        }
        return instance;
    }

    public User authenticate(String username, String password) {
        // Fetch user from the database based on provided username
        User user = databaseUtil.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // Authentication successful
            return user;
        } else {
            // Authentication failed
            return null;
        }
    }

    public boolean registerUser(User newUser) {
        // Check if the user already exists in the database
        if (databaseUtil.getUserByUsername(newUser.getUsername()) != null) {
            // User already exists, registration failed
            return false;
        } else {
            // User does not exist, proceed with registration
            boolean registrationSuccessful = databaseUtil.addUser(newUser);

            if (registrationSuccessful) {
                // Registration successful
                return true;
            } else {
                // Registration failed due to database error
                return false;
            }
        }
    }
}
