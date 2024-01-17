package com.madani.market_place.exception;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String msg) {
        super(msg);
    }
}
