package org.example.views;

import javax.swing.*;
import java.awt.*;

public class AddProductView extends JFrame {

    private JLabel productNameLabel, categoryLabel, sellingPriceLabel, imageLabel, quantityLabel, descriptionLabel, costPriceLabel, minimumStockLevelLabel, unitOfMeasureLabel;
    private JTextField productNameTextField, categoryTextField, sellingPriceTextField, imageTextField, quantityTextField, descriptionTextField, costPriceTextField, minimumStockLevelTextField, unitOfMeasureTextField;

    private JButton addButton, cancelButton;


    public AddProductView() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));

        productNameLabel = new JLabel("Product Name:");
        productNameTextField = new JTextField();
        categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();
        sellingPriceLabel = new JLabel("Selling price:");
        sellingPriceTextField = new JTextField();
        imageLabel = new JLabel("Image link:");
        imageTextField = new JTextField();
        quantityLabel = new JLabel("Quantity:");
        quantityTextField = new JTextField();
        descriptionLabel = new JLabel("Description:");
        descriptionTextField = new JTextField();
        costPriceLabel = new JLabel("Cost price");
        costPriceTextField = new JTextField();
        minimumStockLevelLabel = new JLabel("Minimum stock level:");
        minimumStockLevelTextField = new JTextField();
        unitOfMeasureLabel = new JLabel("Unit of measure:");
        unitOfMeasureTextField = new JTextField();


        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        panel.add(productNameLabel);
        panel.add(productNameTextField);
        panel.add(categoryLabel);
        panel.add(categoryTextField);
        panel.add(sellingPriceLabel);
        panel.add(sellingPriceTextField);
        panel.add(imageLabel);
        panel.add(imageTextField);
        panel.add(quantityLabel);
        panel.add(quantityTextField);
        panel.add(descriptionLabel);
        panel.add(descriptionTextField);
        panel.add(costPriceLabel);
        panel.add(costPriceTextField);
        panel.add(minimumStockLevelLabel);
        panel.add(minimumStockLevelTextField);
        panel.add(unitOfMeasureLabel);
        panel.add(unitOfMeasureTextField);



        var buttonHolder = new JPanel();
        buttonHolder.setLayout(new FlowLayout());
        buttonHolder.add(addButton);
        buttonHolder.add(cancelButton);

        getContentPane().add(buttonHolder, BorderLayout.SOUTH);



        getContentPane().add(panel, BorderLayout.CENTER);
        setVisible(true);
    }


    public JLabel getProductNameLabel() {
        return productNameLabel;
    }

    public void setProductNameLabel(JLabel productNameLabel) {
        this.productNameLabel = productNameLabel;
    }

    public JLabel getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(JLabel categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public JLabel getSellingPriceLabel() {
        return sellingPriceLabel;
    }

    public void setSellingPriceLabel(JLabel sellingPriceLabel) {
        this.sellingPriceLabel = sellingPriceLabel;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    public JLabel getQuantityLabel() {
        return quantityLabel;
    }

    public void setQuantityLabel(JLabel quantityLabel) {
        this.quantityLabel = quantityLabel;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public void setDescriptionLabel(JLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public JLabel getCostPriceLabel() {
        return costPriceLabel;
    }

    public void setCostPriceLabel(JLabel costPriceLabel) {
        this.costPriceLabel = costPriceLabel;
    }

    public JLabel getMinimumStockLevelLabel() {
        return minimumStockLevelLabel;
    }

    public void setMinimumStockLevelLabel(JLabel minimumStockLevelLabel) {
        this.minimumStockLevelLabel = minimumStockLevelLabel;
    }

    public JLabel getUnitOfMeasureLabel() {
        return unitOfMeasureLabel;
    }

    public void setUnitOfMeasureLabel(JLabel unitOfMeasureLabel) {
        this.unitOfMeasureLabel = unitOfMeasureLabel;
    }

    public JTextField getProductNameTextField() {
        return productNameTextField;
    }

    public void setProductNameTextField(JTextField productNameTextField) {
        this.productNameTextField = productNameTextField;
    }

    public JTextField getCategoryTextField() {
        return categoryTextField;
    }

    public void setCategoryTextField(JTextField categoryTextField) {
        this.categoryTextField = categoryTextField;
    }

    public JTextField getSellingPriceTextField() {
        return sellingPriceTextField;
    }

    public void setSellingPriceTextField(JTextField sellingPriceTextField) {
        this.sellingPriceTextField = sellingPriceTextField;
    }

    public JTextField getImageTextField() {
        return imageTextField;
    }

    public void setImageTextField(JTextField imageTextField) {
        this.imageTextField = imageTextField;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public JTextField getDescriptionTextField() {
        return descriptionTextField;
    }

    public void setDescriptionTextField(JTextField descriptionTextField) {
        this.descriptionTextField = descriptionTextField;
    }

    public JTextField getCostPriceTextField() {
        return costPriceTextField;
    }

    public void setCostPriceTextField(JTextField costPriceTextField) {
        this.costPriceTextField = costPriceTextField;
    }

    public JTextField getMinimumStockLevelTextField() {
        return minimumStockLevelTextField;
    }

    public void setMinimumStockLevelTextField(JTextField minimumStockLevelTextField) {
        this.minimumStockLevelTextField = minimumStockLevelTextField;
    }

    public JTextField getUnitOfMeasureTextField() {
        return unitOfMeasureTextField;
    }

    public void setUnitOfMeasureTextField(JTextField unitOfMeasureTextField) {
        this.unitOfMeasureTextField = unitOfMeasureTextField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }


}
