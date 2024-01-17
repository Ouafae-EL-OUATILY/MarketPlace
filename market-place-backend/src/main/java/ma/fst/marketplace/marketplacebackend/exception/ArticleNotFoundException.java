package com.madani.market_place.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String msg) {
        super(msg);
    }
}
