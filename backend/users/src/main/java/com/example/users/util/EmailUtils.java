package com.example.users.util;

import org.apache.commons.validator.routines.EmailValidator;

import com.example.users.exception.EmailNotValidException;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class EmailUtils {

	public static String emailValidation(String email) {
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new EmailNotValidException(email);
		}
		return email;
	}
}
