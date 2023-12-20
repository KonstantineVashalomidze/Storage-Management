package org.example.controllers;

import org.example.services.UsersService;
import org.example.views.UsersView;

public class UsersController
{

    private UsersService usersService;
    private UsersView usersView;

    public UsersController(UsersView usersView, UsersService usersService)
    {
        this.usersView = usersView;
        this.usersService = usersService;

        loadUsersData();

    }

    public void loadUsersData()
    {
        var users = usersService.getAllUsers();
        usersView.displayUsers(users);
    }


}
