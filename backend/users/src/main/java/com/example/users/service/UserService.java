package com.example.users.service;

import java.util.List;

import com.example.users.model.dto.RegistrationConfirmRequest;
import com.example.users.model.dto.RegistrationRequest;
import com.example.users.model.entity.User;

public interface UserService {

	User create(User user);

	void delete(Long id);

	User findByEmailToken(String emailToken);

	List<User> list();

	User registration(RegistrationRequest registrationRequest);

	User registrationConfirmation(RegistrationConfirmRequest registrationConfirmationRequest);

	User update(Long id, User user);

}
