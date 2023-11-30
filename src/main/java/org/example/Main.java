package org.example;

import org.example.services.AuthenticationService;
import org.example.util.DatabaseUtil;
import org.example.views.LoginView;

import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
                new LoginView(new AuthenticationService(new DatabaseUtil())).setVisible(true));
    }
}





