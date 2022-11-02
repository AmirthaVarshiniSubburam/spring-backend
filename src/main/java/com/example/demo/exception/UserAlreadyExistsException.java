package com.example.demo.exception;

public class UserAlreadyExistsException extends Exception {

	private String message;
	public UserAlreadyExistsException() {
		
	}
	public UserAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserAlreadyExistsException [message=" + message + "]";
	}
	
	
	
	
}
