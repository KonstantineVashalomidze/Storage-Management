package org.example.views;

import org.example.views.view_components.BetterButton;
import org.example.views.view_components.BetterComboBox;

import javax.swing.*;
import java.awt.*;

public class NavBar extends JPanel {
    private JTextField searchField = new JTextField("Search");
    private BetterComboBox<String> pageDropdown = new BetterComboBox<>();
    private String[] pageOptions = {"Inventory", "Customers", "Suppliers", "Purchases", "Transactions", "Users", "GraphVisualization"};
    private BetterButton charts = new BetterButton("Charts");

    private BetterButton resizeButton = new BetterButton("Resize");

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


        // Adding the Resize Button
        gbc.gridx = 3; // Adjust column index
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.insets = new Insets(5, 0, 5, 10); // Adjust spacing
        add(resizeButton, gbc);

    }


    public BetterButton getResizeButton() {
        return resizeButton;
    }
    public JTextField getSearchField() {
        return searchField;
    }

    public BetterComboBox<String> getPageDropdown() {
        return pageDropdown;
    }

    public BetterButton getChartsButton() {
        return charts;
    }
}
