package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.JobApplicationDaoImpl;
import com.jbk.entities.JobApplication;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

	@Autowired
	JobApplicationDaoImpl jobApplicationDaoImpl;
	
	@Override
	public int createJobApplication(JobApplication jobApplication) {
		int status = jobApplicationDaoImpl.createJobApplication(jobApplication);
		return status;
	}

}
