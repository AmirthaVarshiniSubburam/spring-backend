package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> userAlreadyExistEntity(){
		return new ResponseEntity<String>("User Already Exist",HttpStatus.CONFLICT);		
		
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundExceptionEntity(){
		return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
	}
	
	
}
