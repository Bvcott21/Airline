package com.edgarjba.airline.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginResponse {
	private String message;
	private Boolean success;
}
