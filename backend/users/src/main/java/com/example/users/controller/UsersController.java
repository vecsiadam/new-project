package com.example.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.model.dto.RegistrationRequest;
import com.example.users.model.dto.UserDTO;
import com.example.users.model.entity.User;
import com.example.users.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

	private final UserService userService;

	@DeleteMapping(path = "/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.delete(id);
	}

	@GetMapping(path = "/{id}", produces = "application/json")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	@GetMapping(produces = "application/json")
	public List<User> list() {
		return userService.list();
	}

	@PostMapping(path = "/registration", consumes = "application/json", produces = "application/json")
	public User registration(@RequestBody RegistrationRequest registrationRequest) {
		return userService.registration(registrationRequest);
	}

	@PutMapping(path = "/update/{id}", consumes = "application/json", produces = "application/json")
	public User update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
		return userService.update(id, userDTO);
	}

}
