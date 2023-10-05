package com.edgarjba.airline.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data @AllArgsConstructor
public class UserDTO {
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
}
