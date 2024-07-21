package com.springboot.restapi.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restapi.entity.InvalidPercentageException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(FieldValidationException.class)
    public ResponseEntity<Map<String, String>> handleFieldValidationException(FieldValidationException ex) {
        return new ResponseEntity<>(ex.getErrors(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InvalidPercentageException.class)
    public ResponseEntity<String> handleInvalidPercentageException(InvalidPercentageException ex) {
    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
//    @ExceptionHandler(PercentageInvalidException.class)
//    public ResponseEntity<String> handlePercentageInvalidException(PercentageInvalidException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//    
//    @ExceptionHandler(RollNoAlreadyExistsException.class)
//    public ResponseEntity<Object> handleRollNoAlreadyExistsException(RollNoAlreadyExistsException ex, WebRequest request) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
//    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
