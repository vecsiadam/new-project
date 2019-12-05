package com.example.users.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationConfirmRequest {

	String username;

	String password;

	String passwordAgain;

	Role role;

	String emailToken;
}
