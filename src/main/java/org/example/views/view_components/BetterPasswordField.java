package org.example.views.view_components;

import javax.swing.*;
import java.awt.*;

public class BetterPasswordField extends JPasswordField {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color textColor = Color.DARK_GRAY;
    private Color borderColor = new Color(180, 180, 180);

    public BetterPasswordField(int columns) {
        super(columns);
        commonInit();
    }

    public BetterPasswordField() {
        super();
        commonInit();
    }

    public void commonInit() {
        // Customize appearance
        setForeground(textColor);
        setCaretColor(textColor);
        setFont(new Font("Arial", Font.PLAIN, 16));
        setBackground(backgroundColor);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

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