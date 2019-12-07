package com.example.users.exception;

public class UsernameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -6922780085718792998L;

	public UsernameAlreadyExistsException() {
		super("Username is already exists!");
	}
}
