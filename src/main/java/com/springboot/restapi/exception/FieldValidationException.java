package com.springboot.restapi.exception;

import java.util.Map;

public class FieldValidationException extends RuntimeException{
	private final Map<String, String> errors;

    public FieldValidationException(Map<String, String> errors) {
        super("Validation failed for: " + errors.toString());
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}