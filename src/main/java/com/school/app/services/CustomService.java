package com.school.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.app.pojos.Grade;
import com.school.app.pojos.Student;
import com.school.app.repos.CustomRepo;

@Service
public class CustomService {
	
	@Autowired
	CustomRepo repo;

	public void addStudent(String name, Grade grade) {
		repo.insertStudent(name, grade);
	}

	public Student getStudentByName(String name) {
		return repo.getStudentByName(name);
	}

	public void deleteStudentByName(String name) {
		repo.deleteStudentByName(name);
	}

}
