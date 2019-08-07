package com.example.turtle.deniofinalproject;

public class InventoryItem {
    //id, name,q
    private String itemName;
    private int quantityOnHand;

    public InventoryItem(String itemName, int quantityOnHand) {

        this.itemName = itemName;
        this.quantityOnHand = quantityOnHand;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }
}
