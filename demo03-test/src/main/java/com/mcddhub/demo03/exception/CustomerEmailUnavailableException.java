package com.mcddhub.demo03.exception;

public class CustomerEmailUnavailableException extends RuntimeException {

    public CustomerEmailUnavailableException(String message) {
        super(message);
    }
}

