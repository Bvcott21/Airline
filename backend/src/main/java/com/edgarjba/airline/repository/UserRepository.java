package com.edgarjba.airline.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edgarjba.airline.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{
	User findByUserName(String userName);

	Optional<User> findOneByUserNameAndPassword(String userName, String password);
}
