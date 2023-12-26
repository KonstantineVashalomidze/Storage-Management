package org.example.views.view_components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class BetterScrollPane extends JScrollPane {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color borderColor = new Color(180, 180, 180);
    private Color scrollBorderColor = new Color(150, 150, 150); // New color for scroll indicator border

    public BetterScrollPane(Component view) {
        super(view);
        customizeScrollPane();
    }

    private void customizeScrollPane() {
        setBorder(BorderFactory.createLineBorder(borderColor));
        getViewport().setBackground(backgroundColor);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        customizeScrollBarUI(getVerticalScrollBar());
        customizeScrollBarUI(getHorizontalScrollBar());
    }

    private void customizeScrollBarUI(JScrollBar scrollBar) {
        scrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(200, 200, 200);
                this.trackColor = backgroundColor;
                this.thumbDarkShadowColor = scrollBorderColor; // Border color for scroll indicators
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
    }


}