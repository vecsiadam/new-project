package com.example.users.service;

import java.util.List;

import com.example.users.model.User;

public interface UserService {

	User create(User user);

	void delete(Long id);

	List<User> list();

	User update(Long id, User user);

}
