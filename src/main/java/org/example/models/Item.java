package org.example.models;

public class Item {

    String itemId;
    String itemName;
    int quantity;
    String description;
    double price;

    public Item(String itemId, String itemName, int quantity, String description, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }


    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {

        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
