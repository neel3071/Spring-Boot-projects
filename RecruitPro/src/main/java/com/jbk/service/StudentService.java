package com.jbk.service;

import java.util.List;

import com.jbk.entities.Student;

public interface StudentService {

	public int createStudent(Student student);
	public Student fetchStudent(long id);
	public List<Student> fetchallStudent2();
}
