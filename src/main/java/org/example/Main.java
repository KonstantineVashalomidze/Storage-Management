package org.example;


import org.example.controllers.RegistrationController;
import org.example.services.AuthenticationService;
import org.example.util.DatabaseUtil;
import org.example.views.RegistrationView;

import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            var registrationView = new RegistrationView();
            var authService = new AuthenticationService(DatabaseUtil.getInstance());
            var registrationController = new RegistrationController(registrationView, authService);
        });
    }
}





