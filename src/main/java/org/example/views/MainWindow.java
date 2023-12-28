package org.example.views;

import org.example.controllers.Controller;
import org.example.controllers.NavBarController;
import org.example.views.view_components.BetterFrame;

import javax.swing.*;
import java.awt.*;


public class MainWindow
    extends BetterFrame
{
    private String windowTitle;

    private JPanel currentPage;



    public MainWindow()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Initialize main panel and layout
        setLayout(new BorderLayout());

        // Create navbar
        var navBar = new NavBar();
        var navBarController = new NavBarController(navBar, this);

        // Set title after it will be initialised
        setTitle(windowTitle);


        add(navBar, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);


    }


    public static void main(String[] args) {

    }



    public void setCurrentPage(JPanel currentPage) {
        // remove current Page from frame
        try {
            remove(this.currentPage);
        } catch (NullPointerException ignored)
        {

        }
        this.currentPage = currentPage;
        // add new Page to frame
        add(this.currentPage, BorderLayout.CENTER);
        validate();
        repaint();
    }



    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
        setTitle(windowTitle);
        repaint();
    }
}
