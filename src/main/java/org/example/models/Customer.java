package org.example.models;

public class Customer implements Model {
    private String customerID;
    private String customerName;
    private String contactInformation;

    // Constructor
    public Customer(String customerID, String customerName, String contactInformation) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactInformation = contactInformation;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
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
