package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.Student;
import com.jbk.entities.User;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int createStudent(Student student) {

		try {
			Session session = sessionFactory.openSession();
			Student dbStudent = session.get(Student.class, student.getId());
			if(dbStudent == null) {
				session.save(student);
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
	public Student fetchStudent(long id) {
		Session session = sessionFactory.openSession();
		Student student = null;
		try {
			student = session.get(Student.class, id);
			
			if(student != null) {
				return student;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return student;
		
	}

	@Override
	public List<Student> fetchallStudent2() {

		Session session = sessionFactory.openSession();
		List<Student> studentList = null;
		try {
			studentList = session.createQuery("FROM Student",Student.class).getResultList();
			if(studentList != null) {
				return studentList;
			}else {
				return null;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return studentList;
	}
}
