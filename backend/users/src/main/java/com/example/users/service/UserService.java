package com.example.users.service;

import java.util.List;

import com.example.users.model.dto.RegistrationConfirmRequest;
import com.example.users.model.dto.RegistrationRequest;
import com.example.users.model.dto.UserDTO;
import com.example.users.model.entity.User;

public interface UserService {

	void delete(Long id);

	User findById(Long id);

	List<User> list();

	User registration(RegistrationRequest registrationRequest);

	User registrationConfirmation(RegistrationConfirmRequest registrationConfirmationRequest);

	User update(Long id, UserDTO user);

}
