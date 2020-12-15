package com.kodilla.csvconverter.domain;

public class Product {
    private int id;
    private int quantity;
    private int price;

    public Product() {
    }

    public Product(int id, int quantity, int price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
