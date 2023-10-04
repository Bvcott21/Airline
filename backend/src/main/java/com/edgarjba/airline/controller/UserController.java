package com.edgarjba.airline.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edgarjba.airline.model.User;
import com.edgarjba.airline.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		log.info("Finding all users...");
		return userService.findAll();
				
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		log.info("Attempting persisting user: " + user);
		User createdUser = userService.save(user);
		
		if(createdUser != null) {
			URI loc = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{userId}")
					.buildAndExpand(user.getUserId())
					.toUri();
			log.info("User persisted successfully, user's location: " + loc);
		return ResponseEntity
					.created(loc)
					.build();
		}
		log.error("User persistance unsuccessful");
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
		
		
	}
}
