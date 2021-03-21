package com.example.unity.discount;

import com.example.unity.discount.model.Dto;
import com.example.unity.discount.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    Discount discount;

    @BeforeEach
    public void setUp() {
        discount = new Discount();
    }

    @Test
    public void givenTwoProducts_thenReturnThemWithCalculatedDiscounts() {
        //given
        List<Product> productList = Arrays.asList(
                new Product("Product1", 1500),
                new Product("Product1", 500)
                );
        double discount = 100;
        Dto dto = new Dto(productList, discount);

        //when
        this.discount.calculateProductDiscounts(dto);

        //then
        assertEquals(75, dto.getProductList().get(0).getDiscount());
        assertEquals(25, dto.getProductList().get(1).getDiscount());
    }
}