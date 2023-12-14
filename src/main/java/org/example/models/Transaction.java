package org.example.models;

public class Transaction {
    private String transactionID;
    private String date;
    private String totalCost;
    private String customerID;
    private String productID;
    private String discountsApplied;

    // Constructor
    public Transaction(String transactionID, String date, String totalCost, String customerID, String productID, String discountsApplied) {
        this.transactionID = transactionID;
        this.date = date;
        this.totalCost = totalCost;
        this.customerID = customerID;
        this.productID = productID;
        this.discountsApplied = discountsApplied;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDiscountsApplied() {
        return discountsApplied;
    }

    public void setDiscountsApplied(String discountsApplied) {
        this.discountsApplied = discountsApplied;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Date: " + date + ", Total Cost: " + totalCost
                + ", Customer ID: " + customerID + ", Product ID: " + productID
                + ", Discounts/Promotions Applied: " + discountsApplied;
    }
}
