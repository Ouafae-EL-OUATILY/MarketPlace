package com.madani.market_place.exception;

public class CommandNotFoundException extends RuntimeException {
    public CommandNotFoundException(String msg) {
        super(msg);
    }
}
