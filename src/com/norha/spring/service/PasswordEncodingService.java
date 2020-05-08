package com.norha.spring.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordEncodingService {
	public String passwordEncoder(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}

}
