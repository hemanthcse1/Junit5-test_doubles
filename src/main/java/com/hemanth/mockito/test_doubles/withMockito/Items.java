package com.hemanth.mockito.test_doubles.withMockito;

import java.time.LocalDate;
import java.util.Date;

public class Items {

    private String itemName;
    private String itemId;
    private double itemPrice;
    private LocalDate itemCreated;

    public Items(String itemName, String itemId, double itemPrice, LocalDate itemCreated) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemCreated = itemCreated;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public LocalDate getItemCreated() {
        return itemCreated;
    }

    public void setItemCreated(LocalDate itemCreated) {
        this.itemCreated = itemCreated;
    }
}
