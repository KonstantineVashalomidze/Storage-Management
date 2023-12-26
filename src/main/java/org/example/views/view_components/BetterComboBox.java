package org.example.views.view_components;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BetterComboBox<T> extends JComboBox<T> {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color textColor = Color.DARK_GRAY;
    private Color borderColor = new Color(180, 180, 180);
    private Color hoverColor = new Color(220, 220, 220);
    private Color selectedColor = new Color(200, 200, 200);

    public BetterComboBox(T[] items) {
        super(items);
        initialize();
    }

    public BetterComboBox() {
        super();
        initialize();
    }

    private void initialize() {
        setForeground(textColor);
        setFont(new Font("Arial", Font.PLAIN, 16));
        setOpaque(true);
        setBackground(backgroundColor);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(borderColor, 1),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));

        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if (!isPopupVisible()) {
                    setBackground(hoverColor);
                }
            }

            public void mouseExited(MouseEvent evt) {
                if (!isPopupVisible()) {
                    setBackground(backgroundColor);
                }
            }

            public void mousePressed(MouseEvent evt) {
                if (isEnabled()) {
                    setBackground(selectedColor);
                }
            }

            public void mouseReleased(MouseEvent evt) {
                if (isEnabled()) {
                    if (!isPopupVisible()) {
                        setBackground(hoverColor);
                    } else {
                        setBackground(selectedColor);
                    }
                }
            }
        });

        setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                label.setBackground(isSelected ? selectedColor : backgroundColor);
                label.setForeground(textColor);
                return label;
            }
        });

        setFocusable(false);
    }


}