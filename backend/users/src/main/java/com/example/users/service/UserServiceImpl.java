package com.example.users.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.users.config.PasswordUtils;
import com.example.users.model.dto.RegistrationConfirmRequest;
import com.example.users.model.dto.RegistrationRequest;
import com.example.users.model.dto.Status;
import com.example.users.model.entity.User;
import com.example.users.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByEmailToken(String emailToken) {
		return userRepository.findByEmailToken(emailToken);
	}

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	// TODO: validálás
	@Override
	public User registration(RegistrationRequest registrationRequest) {
		User user = new User();
		user.setEmail(registrationRequest.getEmail());
		user.setName(registrationRequest.getName());
		user.setStatus(Status.REGISTRATED);
		user.setEmailToken(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	// TODO: validálás
	@Override
	public User registrationConfirmation(RegistrationConfirmRequest registrationConfirmationRequest) {
		User user = findByEmailToken(registrationConfirmationRequest.getEmailToken());
		String salt = PasswordUtils.getSalt(30);
		user.setSalt(salt);
		user.setPassword(PasswordUtils.generateSecurePassword(registrationConfirmationRequest.getPassword(), salt));
		user.setRole(registrationConfirmationRequest.getRole());
		user.setUsername(registrationConfirmationRequest.getUsername());
		user.setStatus(Status.CONFIRMED);
		return userRepository.save(user);
	}

	@Override
	public User update(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
