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
import com.example.users.model.dto.UserDTO;
import com.example.users.model.entity.User;
import com.example.users.repository.UserRepository;
import com.example.users.util.EmailUtils;
import com.example.users.util.PasswordUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public void delete(Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);

	}

	private User findByEmailToken(String emailToken) {
		User user = userRepository.findByEmailToken(emailToken);
		if (user == null) {
			log.error("User not exist! email: {}", emailToken);
			throw new UserNotFoundException();
		}
		user.setSalt(null);
		user.setPassword(null);
		return user;
	}

	@Override
	public User findById(Long id) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			log.error("User not exist! id: {}", id);
			throw new UserNotFoundException();
		}
		user.setSalt(null);
		user.setPassword(null);
		return user;
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
			log.error("Email already exist! email: {}", registrationRequest.getEmail());
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
			log.error("Password not valid. It must containts number, lower/uppercase!");
			throw new PasswordNotValidException();
		}

		if (!registrationConfirmationRequest.getPassword().equals(registrationConfirmationRequest.getPasswordAgain())) {
			log.error("Password not match with confirmation password!");
			throw new PasswordNotMatchException();
		}

		if (userRepository.findByUsername(registrationConfirmationRequest.getUsername()) != null) {
			log.error("User already exist! username: {}", registrationConfirmationRequest.getUsername());
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

	@Override
	public User update(Long id, UserDTO updatableUser) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			log.error("User not exist! id: {}", id);
			throw new UserNotFoundException();
		}

		if (updatableUser.getName() != null) {
			user.setName(updatableUser.getName());
		}

		if (updatableUser.getEmail() != null) {
			user.setEmail(EmailUtils.emailValidation(updatableUser.getEmail()));
		}

		if (updatableUser.getUsername() != null) {
			user.setUsername(updatableUser.getUsername());
		}

		return userRepository.save(user);
	}

}
