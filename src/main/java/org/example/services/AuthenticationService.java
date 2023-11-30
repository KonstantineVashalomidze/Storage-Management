package org.example.services;

import org.example.models.User;
import org.example.util.DatabaseUtil;

public class AuthenticationService {
    private DatabaseUtil databaseUtil;

    public AuthenticationService(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
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
}
