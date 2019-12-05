package com.example.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailToken(String emailToken);

	User findByUsername(String username);

}
