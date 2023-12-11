package org.example.models;

public class Transaction {
    private int transactionID;
    private String date;
    private double totalCost;
    private int customerID;
    private int productID;
    private String discountsApplied;

    // Constructor
    public Transaction(int transactionID, String date, double totalCost, int customerID, int productID, String discountsApplied) {
        this.transactionID = transactionID;
        this.date = date;
        this.totalCost = totalCost;
        this.customerID = customerID;
        this.productID = productID;
        this.discountsApplied = discountsApplied;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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
