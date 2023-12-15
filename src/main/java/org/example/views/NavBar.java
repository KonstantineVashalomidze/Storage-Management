package org.example.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NavBar extends JPanel {
    private JButton inventoryBtn = new JButton("Inventory");
    private JButton loginButton = new JButton("Login");
    private JButton registrationButton = new JButton("Registration");
    private JButton customers = new JButton("Customers");

    private JButton suppliers = new JButton("Suppliers");

    public NavBar() {
        initComponents();
    }


    private void initComponents() {
        JPanel centerPanel = new JPanel(new FlowLayout()); // Grid layout for responsive design

        centerPanel.add(suppliers);
        centerPanel.add(customers);
        centerPanel.add(inventoryBtn);
        centerPanel.add(loginButton);
        centerPanel.add(registrationButton);

        add(centerPanel);

    }

    public JButton getSuppliers()
    {
        return suppliers;
    }

    public JButton getCustomers() {
        return customers;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegistrationButton() {
        return registrationButton;
    }

    public JButton getInventoryBtn() {
        return inventoryBtn;
    }



}
