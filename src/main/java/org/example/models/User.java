package org.example.models;

public class User {

    private static int previousUserId = 0;
    private String username, role, password, userId;

    public User(String username, String role, String password)
    {
        this.username = username;
        this.role = role;
        this.password = password;
        this.userId = "user" + (previousUserId + 1);
        previousUserId++;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }


}
