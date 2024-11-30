package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.InterviewDaoImpl;
import com.jbk.entities.Interview;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	InterviewDaoImpl interviewDaoImpl;
	
	@Override
	public int createInterview(Interview interview) {

		int status = interviewDaoImpl.createInterview(interview);
		return status;
	}

}
