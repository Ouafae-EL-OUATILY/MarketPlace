package com.madani.market_place.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String msg) {
        super(msg);
    }
}
