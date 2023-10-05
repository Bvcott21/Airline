package com.edgarjba.airline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.edgarjba.airline.dto.LoginDTO;
import com.edgarjba.airline.dto.UserDTO;
import com.edgarjba.airline.model.User;
import com.edgarjba.airline.repository.UserRepository;
import com.edgarjba.airline.response.LoginResponse;

@Service
public class UserService {
	private UserRepository userRepo;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User save(UserDTO userDTO) {
		User newUser = new User(
				userDTO.getUserName(),
				userDTO.getFirstName(),
				userDTO.getLastName(),
				passwordEncoder.encode(userDTO.getPassword())
				);
		User savedUser = userRepo.save(newUser);
		if(savedUser != null) {
			return savedUser;
		}
		//throw a user could not be created exception in the future.
		return null;
	}

	public LoginResponse login(LoginDTO loginDTO) {
		String msg = "";
		
		User userFound = userRepo.findByUserName(loginDTO.getUserName());
		
		if(userFound != null) {
			String loginPassword = loginDTO.getPassword();
			String encodedUserFoundPassword = userFound.getPassword();
			
			Boolean isPwdRight = passwordEncoder.matches(loginPassword, encodedUserFoundPassword);
			
			if(isPwdRight) {
				Optional<User> optUser = userRepo.findOneByUserNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
				
				if(optUser.isPresent()) {
					return new LoginResponse("Login Success", true);
				} else {
					return new LoginResponse("Login Failed", false);
				}
			} else {
				return new LoginResponse("Password doesn't match", false);
			} 
		} else {
			return new LoginResponse("User doesn't exist", false);
		}
	}
	
}
