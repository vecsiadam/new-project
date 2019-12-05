package com.example.users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.users.model.User;
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
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public User update(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
