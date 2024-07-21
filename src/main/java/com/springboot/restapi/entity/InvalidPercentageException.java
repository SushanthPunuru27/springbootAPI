package com.springboot.restapi.entity;

public class InvalidPercentageException extends RuntimeException {
    public InvalidPercentageException(String message) {
        super(message);
    }
}
