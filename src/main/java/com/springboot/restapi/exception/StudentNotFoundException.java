package com.springboot.restapi.exception;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String message) {
		super(message);
	}
}
