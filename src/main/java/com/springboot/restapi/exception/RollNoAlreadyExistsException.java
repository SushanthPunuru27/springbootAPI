package com.springboot.restapi.exception;

public class RollNoAlreadyExistsException extends RuntimeException{
	public RollNoAlreadyExistsException(String message) {
        super(message);
    }
}
