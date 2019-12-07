package com.example.users.exception;

public class UsernameOrPasswordNotCorrectException extends RuntimeException {

	private static final long serialVersionUID = -6922780085718792998L;

	public UsernameOrPasswordNotCorrectException() {
		super("Username or password not correct!");
	}
}
