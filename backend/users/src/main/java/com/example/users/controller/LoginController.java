package com.example.users.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.dto.LoginRequest;
import com.example.users.service.LoginService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return loginService.login(loginRequest);
	}

	@PostMapping("/logout/{id}")
	public void logout(@PathVariable("id") Long id) {
		loginService.logout(id);
	}
}
