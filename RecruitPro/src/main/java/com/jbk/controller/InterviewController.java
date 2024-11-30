package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Interview;
import com.jbk.service.InterviewServiceImpl;

@RestController
@RequestMapping("/interview")
public class InterviewController {

	@Autowired
	InterviewServiceImpl interviewServiceImpl;
	
	@PostMapping("/create-interview")
	public String createInterview(@RequestBody Interview interview) {
		int status = interviewServiceImpl.createInterview(interview);
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
}
