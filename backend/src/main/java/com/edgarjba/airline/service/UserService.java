package com.edgarjba.airline.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edgarjba.airline.model.User;
import com.edgarjba.airline.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User save(User user) {
		User savedUser = userRepo.save(user);
		if(savedUser != null) {
			return savedUser;
		}
		//throw a user could not be created exception in the future.
		return null;
	}
	
}
