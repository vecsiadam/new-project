package com.example.users.service;

import org.springframework.stereotype.Service;

import com.example.users.exception.UsernameOrPasswordNotCorrectException;
import com.example.users.model.dto.LoginRequest;
import com.example.users.model.dto.LoginStatus;
import com.example.users.model.entity.User;
import com.example.users.repository.UserRepository;
import com.example.users.util.PasswordUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final UserRepository userRepository;

	@Override
	public String login(LoginRequest loginRequest) {
		User user = userRepository.findByUsername(loginRequest.getUsername());
		if (user == null) {
			throw new UsernameOrPasswordNotCorrectException();
		}

		if (!PasswordUtils.verifyUserPassword(loginRequest.getPassword(), user.getPassword(), user.getSalt())) {
			throw new UsernameOrPasswordNotCorrectException();
		}
		user.setLoginStatus(LoginStatus.LOGGED_IN);
		userRepository.save(user);
		return "BE VAGY JELENTKEZVE BÁTTYA";
	}

	@Override
	public void logout(Long id) {
		User user = userRepository.findById(id).get();
		user.setLoginStatus(LoginStatus.LOGGED_OUT);
		userRepository.save(user);
	}
}
