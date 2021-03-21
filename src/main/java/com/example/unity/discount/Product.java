package com.example.unity.discount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private double price;
    private double discount;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
