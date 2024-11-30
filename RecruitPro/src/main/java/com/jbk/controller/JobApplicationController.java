package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.JobApplication;
import com.jbk.service.JobApplicationServiceImpl;

@RestController
@RequestMapping("/jobApplication")
public class JobApplicationController {

	@Autowired
	JobApplicationServiceImpl jobApplicationServiceImpl;
	
	@PostMapping("/create-job-application")
	public String createJobApplication(@RequestBody JobApplication jobApplication) {
		int status = jobApplicationServiceImpl.createJobApplication(jobApplication);
		switch (status) {
		case 1: {
			return "Job Application has been added successfully!";
		}
		case 2: {
			return "Job Application already exists in the system.";
		}
		case 3: {
			return "Job Application could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
	}
}
