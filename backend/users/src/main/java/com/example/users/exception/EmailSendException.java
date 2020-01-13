package com.example.users.exception;

public class EmailSendException extends RuntimeException {

	private static final long serialVersionUID = -6922780085718792998L;

	public EmailSendException() {
		super("Email could not be sent!");
	}
}
