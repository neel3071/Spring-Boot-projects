package com.jbk.service;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;


public interface UserService {

	public int createUser(User user);
	
	public User getUserByUsername(String username);
	
	public User loginUser(LoginRequest loginRequest);
}
