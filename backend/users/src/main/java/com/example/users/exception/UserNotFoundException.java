package com.example.users.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6922780085718792998L;

	public UserNotFoundException() {
		super("User does not exists!");
	}
}
