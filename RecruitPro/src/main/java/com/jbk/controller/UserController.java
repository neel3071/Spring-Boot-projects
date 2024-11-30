package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.User;
import com.jbk.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody @Valid User user) {
		int status = userServiceImpl.createUser(user);
		switch (status) {
		case 1: {
			return "User has been added successfully!";
		}
		case 2: {
			return "User already exists in the system.";
		}
		case 3: {
			return "User could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
	}
	
	@GetMapping("/by-username/{username}")
	public Object getUserbyUsername(@PathVariable @Valid String username) {
		User user = userServiceImpl.getUserByUsername(username);
		if(user != null) {
			return user;
		}else {
			return "user not found " + username ;
		}
	}
}
