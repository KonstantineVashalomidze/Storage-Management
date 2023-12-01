package org.example.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemDialog extends JDialog {
    private JLabel itemNameLabel;
    private JTextField itemNameTextField;
    private JLabel quantityLabel;
    private JTextField quantityTextField;
    private JLabel descriptionLabel;
    private JTextField descriptionTextField;
    private JLabel priceLabel;
    private JTextField priceTextField;
    private JButton addButton;
    private JButton cancelButton;



    public AddItemDialog(JFrame parent) {
        super(parent, "Add New Item", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));

        itemNameLabel = new JLabel("Item Name:");
        itemNameTextField = new JTextField();
        quantityLabel = new JLabel("Quantity:");
        quantityTextField = new JTextField();
        descriptionLabel = new JLabel("Description:");
        descriptionTextField = new JTextField();
        priceLabel = new JLabel("Price:");
        priceTextField = new JTextField();
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        panel.add(itemNameLabel);
        panel.add(itemNameTextField);
        panel.add(quantityLabel);
        panel.add(quantityTextField);
        panel.add(descriptionLabel);
        panel.add(descriptionTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(addButton);
        panel.add(cancelButton);

        addButton.addActionListener(e -> {
            // Process adding item functionality
            // Retrieve values from text fields and create a new item
            // Example:
            String itemName = itemNameTextField.getText();
            int quantity = Integer.parseInt(quantityTextField.getText());
            String description = descriptionTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());

            // Create a new item using the retrieved values (use your Item class constructor)
            // Item newItem = new Item(itemName, quantity, description, price);

            // Perform the necessary action with the new item (save to database, update UI, etc.)

            // Close the dialog
            dispose();
        });

        cancelButton.addActionListener(e -> {
            // Close the dialog without adding the item
            dispose();
        });

        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
