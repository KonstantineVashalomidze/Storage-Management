package org.example.views;

import javax.swing.*;
import java.awt.*;

public class NavBar extends JPanel {
    private JTextField searchField = new JTextField("Search");
    private JComboBox<String> pageDropdown = new JComboBox<>();
    private String[] pageOptions = {"Inventory", "Customers", "Suppliers", "Purchases", "Transactions", "Users"};
    private JButton charts = new JButton("Charts");

    public NavBar() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Allow components to expand horizontally

        // Search Bar
        searchField.setPreferredSize(new Dimension(150, 30));
        searchField.setForeground(Color.GRAY);
        searchField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));

        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("Search")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setForeground(Color.GRAY);
                    searchField.setText("Search");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 10); // Adjust spacing
        add(searchField, gbc);

        // Dropdown Menu
        for (String option : pageOptions) {
            pageDropdown.addItem(option);
        }

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.insets = new Insets(5, 0, 5, 10); // Adjust spacing
        add(pageDropdown, gbc);

        // Dropdown Action Listener
        pageDropdown.addActionListener(e -> {
            String selectedPage = (String) pageDropdown.getSelectedItem();
            System.out.println("Navigating to: " + selectedPage);
            // Implement navigation logic here
        });

        // Charts Button
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.insets = new Insets(5, 0, 5, 10); // Adjust spacing
        add(charts, gbc);

    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JComboBox<String> getPageDropdown() {
        return pageDropdown;
    }

    public JButton getChartsButton() {
        return charts;
    }
}
