package org.example.views;

import javax.swing.*;
import java.awt.*;

public class AddItemView extends JFrame {

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


    public AddItemView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);


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






        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public JButton getAddButton()
    {
        return addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JTextField getItemNameTextField() {
        return itemNameTextField;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public JTextField getDescriptionTextField() {
        return descriptionTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

}
