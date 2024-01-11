package org.example.models;

import java.util.Date;

public class Product implements Model {
    private String productName;
    private String category;
    private String sellingPrice;
    private String image;
    private String stockQuantity;
    private String description;
    private String costPrice;
    private String minimumStockLevel;
    private String unitOfMeasure;
    private String dateAdded;
    private String lastUpdated;
    private String productID;

    // Constructor
    public Product(String productName, String category, String sellingPrice, String image, String stockQuantity,
                   String description, String costPrice, String minimumStockLevel, String unitOfMeasure,
                   String dateAdded, String lastUpdated, String productID) {
        this.productName = productName;
        this.category = category;
        this.sellingPrice = sellingPrice;
        this.image = image;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.costPrice = costPrice;
        this.minimumStockLevel = minimumStockLevel;
        this.unitOfMeasure = unitOfMeasure;
        this.dateAdded = dateAdded;
        this.lastUpdated = lastUpdated;
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(String minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Product ID: " + productID + ", Product Name: " + productName + ", Category: " + category
                + ", Selling Price: " + sellingPrice + ", Image: " + image + ", Stock Quantity: " + stockQuantity
                + ", Description: " + description + ", Cost Price: " + costPrice + ", Minimum Stock Level: "
                + minimumStockLevel + ", Unit of Measure: " + unitOfMeasure + ", Date Added: " + dateAdded
                + ", Last Updated: " + lastUpdated;
    }
}
