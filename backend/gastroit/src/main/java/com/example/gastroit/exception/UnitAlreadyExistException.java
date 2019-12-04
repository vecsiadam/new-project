package com.example.gastroit.exception;

public class UnitAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 7650034570292234565L;

	public UnitAlreadyExistException() {
		super("The unit is already exist!");
	}
}
