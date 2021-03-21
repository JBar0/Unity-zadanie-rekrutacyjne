package com.example.unity.discount;

import com.example.unity.discount.model.Dto;
import org.springframework.stereotype.Service;

@Service
public class Discount {

    public Dto calculateProductDiscounts(Dto dto) {
        dto.calculateDiscounts();
        return dto;
    }
}
