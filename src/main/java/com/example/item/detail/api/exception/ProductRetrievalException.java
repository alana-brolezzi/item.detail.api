package com.example.item.detail.api.exception;

public class ProductRetrievalException extends RuntimeException {

    public ProductRetrievalException(String message) {
        super(message);
    }

    public ProductRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductRetrievalException(Throwable cause) {
        super(cause);
    }
}
