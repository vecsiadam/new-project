package com.example.users.exception;

public class EmailAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = -6922780085718792998L;

	public EmailAlreadyExistsException() {
		super("Email already exists!");
	}
}
