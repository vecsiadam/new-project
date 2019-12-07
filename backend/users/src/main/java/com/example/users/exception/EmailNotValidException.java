package com.example.users.exception;

public class EmailNotValidException extends RuntimeException {

	private static final long serialVersionUID = -6922780085718792998L;

	public EmailNotValidException(String email) {
		super("Email does not valid: " + email);
	}
}
