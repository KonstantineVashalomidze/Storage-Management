package org.example.models;

public class Customer {
    private int customerID;
    private String customerName;
    private String contactInformation;

    // Constructor
    public Customer(int customerID, String customerName, String contactInformation) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactInformation = contactInformation;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Customer Name: " + customerName + ", Contact Information: " + contactInformation;
    }
}
