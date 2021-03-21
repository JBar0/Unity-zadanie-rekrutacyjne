package com.example.unity.discount;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public ProductSet calculateProductDiscounts(ProductSet productSet) {
        productSet.calculateDiscounts();
        return productSet;
    }
}
