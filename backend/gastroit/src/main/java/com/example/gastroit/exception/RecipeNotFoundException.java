package com.example.gastroit.exception;

public class RecipeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6922780085718792998L;

	public RecipeNotFoundException() {
		super("The recipe does not exist!");
	}
}
