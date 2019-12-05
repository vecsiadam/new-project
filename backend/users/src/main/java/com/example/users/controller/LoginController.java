package com.example.users.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.dto.LoginRequest;
import com.example.users.service.LoginService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

	private final LoginService loginService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public String login(@RequestBody LoginRequest loginRequest) {
		return loginService.login(loginRequest);
	}
}
