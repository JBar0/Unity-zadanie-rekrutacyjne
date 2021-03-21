package com.example.unity.discount;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Empty list of products")
public class EmptyProductListException extends RuntimeException {
}
