package com.example.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.dto.RegistrationConfirmRequest;
import com.example.users.model.dto.RegistrationRequest;
import com.example.users.model.entity.User;
import com.example.users.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

	private final UserService userService;

	@GetMapping(produces = "application/json")
	public List<User> list() {
		return userService.list();
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
	
	@PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
	public User registration(@RequestBody RegistrationRequest registrationRequest) {
		return userService.registration(registrationRequest);
	}

	@PostMapping(path = "/registration-confirmation", consumes = "application/json", produces = "application/json")
	public User registrationConfirmation(@RequestBody RegistrationConfirmRequest registrationConfirmationRequest) {
		return userService.registrationConfirmation(registrationConfirmationRequest);
	}
}
