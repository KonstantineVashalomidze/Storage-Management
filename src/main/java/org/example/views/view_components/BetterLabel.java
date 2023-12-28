package org.example.views.view_components;

import javax.swing.*;
import java.awt.*;

public class BetterLabel extends JLabel {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color textColor = Color.DARK_GRAY;
    private Color borderColor = new Color(180, 180, 180);

    public BetterLabel(String text) {
        super(text);
        customizeLabel();
    }

    private void customizeLabel() {
        setForeground(textColor);
        setBackground(backgroundColor);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(borderColor));
        setFont(new Font("Arial", Font.PLAIN, 14));
        setHorizontalAlignment(SwingConstants.CENTER); // Centers the text horizontally

        // Add hover effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(220, 220, 220));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(backgroundColor);
            }
        });
    }

}