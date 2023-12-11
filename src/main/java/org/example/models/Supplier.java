package org.example.models;

public class Supplier {
    private int supplierID;
    private String supplierName;
    private String contactInformation;

    // Constructor
    public Supplier(int supplierID, String supplierName, String contactInformation) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactInformation = contactInformation;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
        return "Supplier ID: " + supplierID + ", Supplier Name: " + supplierName + ", Contact Information: " + contactInformation;
    }
}
