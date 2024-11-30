package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import com.jbk.exceptions.ResorceNotFoundExpection;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int createUser(User user) {
		
		Session session = sessionFactory.openSession();
		User dbUser = session.get(User.class, user.getUsername());
		try {
			if(dbUser == null) {
				session.save(user);
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

	@Override
	public User getUserByUsername(String username) {

		Session session = sessionFactory.openSession();
		
		
		User user = session.get(User.class, username);
			
			if(user != null) {
				return user;
			}else {
				throw new ResorceNotFoundExpection(username + "User not found") ;
			} 
		
	
	}

	@Override
	public User loginUser(LoginRequest loginRequest) {
	    try {
	    	Session session = sessionFactory.openSession();
		    User dbUser = session.get(User.class, loginRequest.getUsername());
		    if(dbUser != null) {
		    	if(dbUser.getPassword().equals(loginRequest.getPassword())) {
			    	return dbUser;
			    }
		    }else {
		    	return null;
		    }
		} catch (Exception e) {

			e.printStackTrace();
		}
	    
	    return null;
	}
}
