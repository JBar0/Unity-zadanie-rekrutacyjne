package com.example.unity.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountServiceTest {

    DiscountService discountService;

    @BeforeEach
    public void setUp() {
        discountService = new DiscountService();
    }

    @Test
    public void givenEmptyList_thenThrowEmptyListException() {
        //given
        List<Product> productList = Collections.emptyList();
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when, then
        assertThrows(EmptyProductListException.class, () -> discountService.calculateProductDiscounts(productSet));
    }

    @Test
    public void givenMoreThanFiveProducts_thenThrowOverFiveProductsException() {
        //given
        List<Product> productList = Arrays.asList(
                new Product("Product1", 5000),
                new Product("Product2", 2000),
                new Product("Product3", 1000),
                new Product("Product4", 1000),
                new Product("Product5", 1000),
                new Product("Product6", 1000)
        );
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when, then
        assertThrows(OverFiveProductsException.class, () -> discountService.calculateProductDiscounts(productSet));
    }

    @Test
    public void givenOneProduct_thenReturnThemWithCalculatedDiscounts() {
        //given
        List<Product> productList = Collections.singletonList(
                new Product("Product1", 1000)
        );
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when
        this.discountService.calculateProductDiscounts(productSet);

        //then
        assertEquals(100, productSet.getProductList().get(0).getDiscount());
    }

    @Test
    public void givenTwoProducts_thenReturnThemWithCalculatedDiscounts() {
        //given
        List<Product> productList = Arrays.asList(
                new Product("Product1", 1500),
                new Product("Product2", 500)
                );
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when
        this.discountService.calculateProductDiscounts(productSet);

        //then
        assertEquals(75, productSet.getProductList().get(0).getDiscount());
        assertEquals(25, productSet.getProductList().get(1).getDiscount());
    }

    @Test
    public void givenThreeProducts_thenReturnThemWithCalculatedDiscounts() {
        //given
        List<Product> productList = Arrays.asList(
                new Product("Product1", 1000),
                new Product("Product2", 500),
                new Product("Product3", 500)
        );
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when
        this.discountService.calculateProductDiscounts(productSet);

        //then
        assertEquals(50, productSet.getProductList().get(0).getDiscount());
        assertEquals(25, productSet.getProductList().get(1).getDiscount());
        assertEquals(25, productSet.getProductList().get(2).getDiscount());
    }

    @Test
    public void givenFourProducts_thenReturnThemWithCalculatedDiscounts() {
        //given
        List<Product> productList = Arrays.asList(
                new Product("Product1", 500),
                new Product("Product2", 500),
                new Product("Product3", 500),
                new Product("Product4", 500)
        );
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when
        this.discountService.calculateProductDiscounts(productSet);

        //then
        assertEquals(25, productSet.getProductList().get(0).getDiscount());
        assertEquals(25, productSet.getProductList().get(1).getDiscount());
        assertEquals(25, productSet.getProductList().get(2).getDiscount());
        assertEquals(25, productSet.getProductList().get(3).getDiscount());
    }

    @Test
    public void givenFiveProducts_thenReturnThemWithCalculatedDiscounts() {
        //given
        List<Product> productList = Arrays.asList(
                new Product("Product1", 5000),
                new Product("Product2", 2000),
                new Product("Product3", 1000),
                new Product("Product4", 1000),
                new Product("Product5", 1000)
        );
        double discount = 100;
        ProductSet productSet = new ProductSet(productList, discount);

        //when
        this.discountService.calculateProductDiscounts(productSet);

        //then
        assertEquals(50, productSet.getProductList().get(0).getDiscount());
        assertEquals(20, productSet.getProductList().get(1).getDiscount());
        assertEquals(10, productSet.getProductList().get(2).getDiscount());
        assertEquals(10, productSet.getProductList().get(3).getDiscount());
        assertEquals(10, productSet.getProductList().get(4).getDiscount());
    }
}