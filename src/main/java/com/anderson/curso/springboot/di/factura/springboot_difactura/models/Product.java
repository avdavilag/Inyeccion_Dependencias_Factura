package com.anderson.curso.springboot.di.factura.springboot_difactura.models;

public class Product {
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Product() {
        // Empty constructor
    }

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
