package org.example.models;

public class Purchase {
    private int purchaseID;
    private String purchaseDate;
    private String deliveryDate;
    private int quantity;
    private int supplierID;
    private int productID;
    private int userID;

    // Constructor
    public Purchase(int purchaseID, String purchaseDate, String deliveryDate, int quantity, int supplierID, int productID, int userID) {
        this.purchaseID = purchaseID;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.supplierID = supplierID;
        this.productID = productID;
        this.userID = userID;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Purchase ID: " + purchaseID + ", Purchase Date: " + purchaseDate + ", Delivery Date: " + deliveryDate
                + ", Quantity: " + quantity + ", Supplier ID: " + supplierID + ", Product ID: " + productID
                + ", User ID: " + userID;
    }
}
