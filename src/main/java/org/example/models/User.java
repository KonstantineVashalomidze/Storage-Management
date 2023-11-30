package org.example.models;

public class User {

    String username, role, password, userId, email, name;

    public User(String username, String role, String password, String userId, String email, String name)
    {
        this.username = username;
        this.role = role;
        this.password = password;
        this.userId = userId;
        this.email = email;
        this.name = name;
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