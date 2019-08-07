package com.example.turtle.deniofinalproject;

public class ShoppingListItem {
    private String ItemName;
    private Boolean onHand;
    private int quantity;

    public ShoppingListItem(String name, Boolean tmpOnHand, int tmpQuantity){
        this.ItemName = name;
        this.onHand = tmpOnHand;
        this.quantity = tmpQuantity;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Boolean getOnHand() {
        return onHand;
    }

    public void setOnHand(Boolean onHand) {
        this.onHand = onHand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
