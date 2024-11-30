package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Student;
import com.jbk.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/create-student")
	public String createStudent(@RequestBody Student student) {

		int status = studentServiceImpl.createStudent(student);
		switch (status) {
		case 1: {
			return "Student has been added successfully!";
		}
		case 2: {
			return "Student already exists in the system.";
		}
		case 3: {
			return "Student could not be found in the system.";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + status);
		}
	}
	@GetMapping("/by-id/{id}")
	public Object fetchStudent(@PathVariable long id) {
		Student student = studentServiceImpl.fetchStudent(id);
		if( student!= null) {
			return student;
		}else {
			return "student not found for username = " + id;
		}
	}
	@GetMapping("GetAllStudent")
	public List<Student> fetchallStudent() {
		
		
		List<Student> list = studentServiceImpl.fetchallStudent2();
		if(!list.isEmpty()) {
			return list;
		}else {
			return null;
		}
		
		
		
		
		
		
	}
}
