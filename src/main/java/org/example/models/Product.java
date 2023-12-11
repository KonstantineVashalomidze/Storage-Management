package org.example.models;

import java.util.Date;

public class Product {
    private String productName;
    private String category;
    private double sellingPrice;
    private String image;
    private int stockQuantity;
    private String description;
    private double costPrice;
    private int minimumStockLevel;
    private String unitOfMeasure;
    private Date dateAdded;
    private Date lastUpdated;
    private int productID;

    // Constructor
    public Product(String productName, String category, double sellingPrice, String image, int stockQuantity,
                   String description, double costPrice, int minimumStockLevel, String unitOfMeasure,
                   Date dateAdded, Date lastUpdated, int productID) {
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

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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
