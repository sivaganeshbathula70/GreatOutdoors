package com.cg.greatoutdoors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GreatOutdoorExceptionHandler {
	@ExceptionHandler(value=AddressNotFoundException.class)
	public ResponseEntity<Object> handleException(AddressNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=IdNotFoundException.class)
	public ResponseEntity<Object> handleException1(IdNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=AddressException.class)
	public ResponseEntity<Object> handleException3(AddressException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
