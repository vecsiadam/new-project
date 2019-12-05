package com.example.gastroit.exception;

public class UnitNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7725114196991400238L;

	public UnitNotFoundException() {
		super("The unit does not exist!");
	}

	public UnitNotFoundException(String unit) {
		super("The unit does not exist: " + unit);
	}
}
