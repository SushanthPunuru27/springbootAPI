package com.springboot.restapi.exception;

public class PercentageInvalidException extends RuntimeException{
	public PercentageInvalidException(String message) {
		super(message); 
	}
}
