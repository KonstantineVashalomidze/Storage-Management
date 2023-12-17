package org.example.views;

import javax.swing.*;
import java.awt.*;

public class NavBar
    extends JPanel
{
    private JButton inventoryBtn = new JButton("Inventory");
    private JButton customersBtn = new JButton("Customers");

    private JButton suppliersBtn = new JButton("Suppliers");

    private JButton purchasesBtn = new JButton("Purchases");

    private JButton transactionsBtn = new JButton("Transactions");

    public NavBar() {
        initComponents();
    }


    private void initComponents() {
        JPanel centerPanel = new JPanel(new FlowLayout()); // Grid layout for responsive design

        centerPanel.add(suppliersBtn);
        centerPanel.add(customersBtn);
        centerPanel.add(inventoryBtn);
        centerPanel.add(purchasesBtn);
        centerPanel.add(transactionsBtn);

        add(centerPanel);

    }

    public JButton getSuppliersBtn()
    {
        return suppliersBtn;
    }
    public JButton getCustomersBtn() {
        return customersBtn;
    }
    public JButton getInventoryBtn() {
        return inventoryBtn;
    }
    public JButton getPurchaseBtn() {
        return purchasesBtn;
    }
    public JButton getTransactionsBtn() {
        return transactionsBtn;
    }
}
