package com.jbk.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDaoImpl;
import com.jbk.entities.Student;

@Service
@Scope("prototype")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@Override
	public int createStudent(Student student) {

		int status = studentDaoImpl.createStudent(student);
		return status;
	}

	@Override
	public Student fetchStudent(long id) {
		Student student = studentDaoImpl.fetchStudent(id);
		return student;
		
	}

	@Override
	public List<Student> fetchallStudent2() {

		List<Student> studentList = studentDaoImpl.fetchallStudent2();
		return studentList;
	}

}
