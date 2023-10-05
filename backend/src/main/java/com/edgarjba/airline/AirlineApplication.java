package com.edgarjba.airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
 * exclude = SecurityAutoConfiguration.class 
 * 
 * allows to 'disable' Spring Security (useful on initial stages)
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AirlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineApplication.class, args);
	}

}
