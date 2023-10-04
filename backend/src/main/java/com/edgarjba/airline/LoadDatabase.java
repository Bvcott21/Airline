package com.edgarjba.airline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edgarjba.airline.model.User;
import com.edgarjba.airline.repository.UserRepository;

@Configuration
public class LoadDatabase  {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepo) {
		return args -> {
			log.info("Preloading user: " + userRepo.save(
					new User("test-user-1", 
							"test-first-name-1", 
							"test-last-name-1", 
							"P4ssword"))
			);
			log.info("Preloading user: " + userRepo.save(
					new User("test-user-2", 
							"test-first-name-2", 
							"test-last-name-2", 
							"P4ssword"))
			);
			log.info("Preloading user: " + userRepo.save(
					new User("test-user-3", 
							"test-first-name-3", 
							"test-last-name-3", 
							"P4ssword"))
			);
		};
	}

}
