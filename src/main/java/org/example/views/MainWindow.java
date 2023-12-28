package org.example.views;

import org.example.views.view_components.BetterFrame;

import javax.swing.*;


public class MainWindow
    extends BetterFrame
{
    private String windowTitle = "Inventory Management";

    public MainWindow()
    {
        setTitle(windowTitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);





        setLocationRelativeTo(null);
        setVisible(true);


    }




    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }
}
