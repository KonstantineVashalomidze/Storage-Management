package org.example.models;

public class Purchase {
    private String purchaseID;
    private String purchaseDate;
    private String deliveryDate;
    private String quantity;
    private String supplierID;
    private String productID;
    private String userID;

    // Constructor
    public Purchase(String purchaseID, String purchaseDate, String deliveryDate, String quantity, String supplierID, String productID, String userID) {
        this.purchaseID = purchaseID;
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.supplierID = supplierID;
        this.productID = productID;
        this.userID = userID;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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
