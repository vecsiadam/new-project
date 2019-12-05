package com.example.users.service;

import org.springframework.stereotype.Service;

import com.example.users.config.PasswordUtils;
import com.example.users.model.dto.LoginRequest;
import com.example.users.model.dto.LoginStatus;
import com.example.users.model.entity.User;
import com.example.users.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final UserRepository userRepository;

	@Override
	public String login(LoginRequest loginRequest) {
		User user = userRepository.findByUsername(loginRequest.getUsername());

		if (PasswordUtils.verifyUserPassword(loginRequest.getPassword(), user.getPassword(), user.getSalt())) {
			user.setLoginStatus(LoginStatus.LOGGED_IN);
			userRepository.save(user);
			return "BE VAGY JELENTKEZVE BÁTTYA";
		}
		return "EZ MOST NEM JÖTT ÖSSZE";
	}

	@Override
	public void logout(Long id) {
		User user = userRepository.findById(id).get();
		user.setLoginStatus(LoginStatus.LOGGED_OUT);
		userRepository.save(user);
	}
}
