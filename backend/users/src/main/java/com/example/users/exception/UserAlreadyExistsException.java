package com.example.users.exception;

public class UserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = -6922780085718792998L;

	public UserAlreadyExistsException() {
		super("User already exists!");
	}
}
