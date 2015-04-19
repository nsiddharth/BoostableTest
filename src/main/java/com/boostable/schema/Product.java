package com.boostable.schema;

/**
 * Created by siddharn on 4/19/15.
 */
public class Product {

    private int product_id;
    private String name;
    private String description;
    private double price;

    public Product(int product_id, String name, String description, double price) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }


}
