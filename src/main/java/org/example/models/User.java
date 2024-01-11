package org.example.models;

public class User implements Model {

    public static int maxiMumUserID = 0;
    private String username, role, password, userId;

    public User(String username, String role, String password, String userId)
    {
        this.username = username;
        this.role = role;
        this.password = password;
        this.userId = userId;
    }

    public User(String username, String role, String password)
    {
        this.username = username;
        this.role = role;
        this.password = password;
        maxiMumUserID++;
        this.userId = "user" + maxiMumUserID;
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
