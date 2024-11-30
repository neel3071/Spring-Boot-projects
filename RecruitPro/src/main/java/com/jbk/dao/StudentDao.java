package com.jbk.dao;

import java.util.List;

import com.jbk.entities.Student;

public interface StudentDao {

	public int createStudent(Student student);
	public Student fetchStudent(long id);
	public List<Student> fetchallStudent2();
	
}
