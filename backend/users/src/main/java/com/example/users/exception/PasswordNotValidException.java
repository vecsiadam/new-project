package com.example.users.exception;

public class PasswordNotValidException extends RuntimeException {

	private static final long serialVersionUID = -6922780085718792998L;

	public PasswordNotValidException() {
		super("Password does not valid! It must be contains number, lower case and upper case!");
	}
}
