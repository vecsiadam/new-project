package com.example.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.users.exception.EmailAlreadyExistsException;
import com.example.users.exception.PasswordNotMatchException;
import com.example.users.exception.PasswordNotValidException;
import com.example.users.exception.UserNotFoundException;
import com.example.users.exception.UsernameAlreadyExistsException;
import com.example.users.model.dto.RegistrationConfirmRequest;
import com.example.users.model.dto.RegistrationRequest;
import com.example.users.model.dto.Status;
import com.example.users.model.entity.User;
import com.example.users.repository.UserRepository;
import com.example.users.util.EmailUtils;
import com.example.users.util.PasswordUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	// TODO:
	@Override
	public void delete(Long id) {

	}

	@Override
	public List<User> list() {
		List<User> users = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			user.setSalt(null);
			user.setPassword(null);
			users.add(user);
		}
		return users;
	}

	@Override
	public User registration(RegistrationRequest registrationRequest) {
		User tempUser = userRepository.findByEmail(registrationRequest.getEmail());
		if (tempUser != null) {
			throw new EmailAlreadyExistsException();
		}
		User user = new User();
		user.setEmail(EmailUtils.emailValidation(registrationRequest.getEmail()));
		user.setName(registrationRequest.getName());
		user.setStatus(Status.REGISTRATED);
		user.setEmailToken(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public User registrationConfirmation(RegistrationConfirmRequest registrationConfirmationRequest) {

		if (!PasswordUtils.passwordOk(registrationConfirmationRequest.getPassword())) {
			throw new PasswordNotValidException();
		}

		if (!registrationConfirmationRequest.getPassword().equals(registrationConfirmationRequest.getPasswordAgain())) {
			throw new PasswordNotMatchException();
		}

		if (userRepository.findByUsername(registrationConfirmationRequest.getUsername()) != null) {
			throw new UsernameAlreadyExistsException();
		}

		User user = findByEmailToken(registrationConfirmationRequest.getEmailToken());
		user.setUsername(registrationConfirmationRequest.getUsername());

		String salt = PasswordUtils.getSalt(30);
		user.setSalt(salt);
		user.setPassword(PasswordUtils.generateSecurePassword(registrationConfirmationRequest.getPassword(), salt));
		user.setRole(registrationConfirmationRequest.getRole());

		user.setStatus(Status.CONFIRMED);
		return userRepository.save(user);
	}

	// TODO:
	@Override
	public User update(Long id, User user) {
		return null;
	}

	@Override
	public User findById(Long id) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			throw new UserNotFoundException();
		}
		user.setSalt(null);
		user.setPassword(null);
		return user;
	}

	private User findByEmailToken(String emailToken) {
		User user = userRepository.findByEmailToken(emailToken);
		if (user == null) {
			throw new UserNotFoundException();
		}
		user.setSalt(null);
		user.setPassword(null);
		return user;
	}

}
