package com.edgarjba.airline.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "airline_user")
@NoArgsConstructor @Data
public class User {
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	
	public User(String userName, String firstName, String lastName, String password) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
}
