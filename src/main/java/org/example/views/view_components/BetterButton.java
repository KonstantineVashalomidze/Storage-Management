package org.example.views.view_components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BetterButton extends JButton {

    private Color baseColor = new Color(240, 240, 240);
    private Color defaultTextColor = Color.DARK_GRAY;
    private Color hoverColor = new Color(200, 200, 200);
    private Color hoverTextColor = Color.WHITE;
    private Color clickColor = new Color(180, 180, 180);
    private Color shadowColor = new Color(200, 200, 200);
    private Color borderColor = new Color(180, 180, 180);

    private boolean isPressed = false;

    public BetterButton(String text) {
        super(text);
        setPreferredSize(new Dimension(150, 50)); // Set preferred size

        // Customize appearance
        setForeground(defaultTextColor);
        setFont(new Font("Arial", Font.BOLD, 16));

        // Create a compound border with inner and outer borders
        Border outer = BorderFactory.createLineBorder(borderColor, 1);
        Border inner = BorderFactory.createEmptyBorder(8, 15, 8, 15);
        setBorder(BorderFactory.createCompoundBorder(outer, inner));

        setContentAreaFilled(false);
        setFocusPainted(false);

        // Add hover effect
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (!isPressed) {
                    setBackground(hoverColor);
                    setForeground(hoverTextColor);
                }
            }

            public void mouseExited(MouseEvent e) {
                if (!isPressed) {
                    setBackground(baseColor);
                    setForeground(defaultTextColor);
                }
            }

            public void mousePressed(MouseEvent e) {
                setBackground(clickColor);
                isPressed = true;
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                if (isPressed) {
                    setBackground(hoverColor);
                    setForeground(hoverTextColor);
                    isPressed = false;
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Paint the gradient background
        GradientPaint gradient = new GradientPaint(0, 0, baseColor, 0, height, shadowColor);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, width, height);

        // Draw text
        super.paintComponent(g2);

        // Draw click effect shadow
        if (isPressed) {
            g2.setColor(new Color(0, 0, 0, 30));
            g2.fillRect(0, 0, width, height);
        }

        g2.dispose();
    }


}
