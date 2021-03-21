package com.example.unity.discount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {

    DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping("/discount")
    public ProductSet getProductsWithCalculatedDiscounts(@RequestBody ProductSet productSet) {
        return discountService.calculateProductDiscounts(productSet);
    }
}
