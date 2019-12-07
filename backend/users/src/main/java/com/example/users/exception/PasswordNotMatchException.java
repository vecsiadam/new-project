package com.example.users.exception;

public class PasswordNotMatchException extends RuntimeException{

	private static final long serialVersionUID = -6922780085718792998L;

	public PasswordNotMatchException() {
		super("Passwords does not match!");
	}
}
