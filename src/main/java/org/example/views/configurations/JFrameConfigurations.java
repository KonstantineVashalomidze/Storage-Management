package org.example.views.configurations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class JFrameConfigurations
{
    private static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 800, 800);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JButton openRedPanel = new JButton("red panel");
        JButton openBluePanel = new JButton("blue panel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue); // Corrected panel color setting

        openRedPanel.addActionListener(e -> {
            frame.remove(bluePanel);
            frame.add(redPanel);
            frame.revalidate();
            frame.repaint();
        });

        openBluePanel.addActionListener(e -> {
            frame.remove(redPanel);
            frame.add(bluePanel);
            frame.revalidate();
            frame.repaint();
        });

        buttonPanel.add(openRedPanel);
        buttonPanel.add(openBluePanel); // Fixed: Adding openBluePanel to buttonPanel

        frame.getContentPane().add(buttonPanel);
        frame.getContentPane().add(redPanel); // Displaying redPanel initially

        makeFullScreen(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    // this method adds logic of full screen mode.
    public static void makeFullScreen(JFrame frame)
    {
        // makes window full screen
        device.setFullScreenWindow(frame);
    }

    // this method makes window default screen
    public static void makeDefaultScreen(JFrame frame)
    {
        device.setFullScreenWindow(null);
    }

}







