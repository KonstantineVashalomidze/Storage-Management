package org.example.models;

public class Supplier implements Model {
    private String supplierID;
    private String supplierName;
    private String contactInformation;

    // Constructor
    public Supplier(String supplierID, String supplierName, String contactInformation) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactInformation = contactInformation;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
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
