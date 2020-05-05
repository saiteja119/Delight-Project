package com.CapG.Delight.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductOrderExceptionController {
	
	

	
	@ExceptionHandler(value=ProductOrderIdNotFoundException.class)
	public ResponseEntity<Object> handleException(ProductOrderIdNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=UserTypeException.class)
	public ResponseEntity<Object> handleException(UserTypeException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}