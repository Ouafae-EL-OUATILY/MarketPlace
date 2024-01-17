package com.madani.market_place.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
