package com.example.unity.discount;

import com.example.unity.discount.model.Dto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Discount discount;

    public Controller(Discount discount) {
        this.discount = discount;
    }

    @GetMapping
    public Dto getProductsWithCalculatedDiscounts(@RequestBody Dto dto) {
        return discount.calculateProductDiscounts(dto);
    }
}
