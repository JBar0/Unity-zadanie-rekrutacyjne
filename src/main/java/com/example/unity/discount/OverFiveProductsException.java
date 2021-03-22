package com.example.unity.discount;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Given more than 5 products")
public class OverFiveProductsException extends RuntimeException {
}
