package com.example.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.User;
import com.example.users.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

	private final UserService userService;

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping
	public List<User> list() {
		return userService.list();
	}
}
