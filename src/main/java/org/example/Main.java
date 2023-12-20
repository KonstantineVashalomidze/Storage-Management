package org.example;




import org.example.controllers.RegistrationController;
import org.example.views.RegistrationView;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // uncomment this for better looking UI
        EventQueue.invokeLater(() -> {
            var registrationView = new RegistrationView();
            var registrationController = new RegistrationController(registrationView);
        });


    }
}





