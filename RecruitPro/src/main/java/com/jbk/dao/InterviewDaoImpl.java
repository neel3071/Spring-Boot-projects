package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.Interview;

@Repository
public class InterviewDaoImpl implements InterviewDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int createInterview(Interview interview) {

		Session session = sessionFactory.openSession();
		Interview dbInterview = session.get(Interview.class, interview.getId());
	    try {
	    	if(dbInterview == null) {
				session.save(interview);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return 3;
		}
	}

}
