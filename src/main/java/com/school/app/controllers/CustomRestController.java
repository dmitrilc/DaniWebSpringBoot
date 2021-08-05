package com.school.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.app.pojos.Student;
import com.school.app.services.CustomService;

@RestController
public class CustomRestController {
	
	@Autowired
	private CustomService service;
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		service.addStudent(
				student.getName(), 
				student.getGrade());
	}
	
	@GetMapping("/getStudent")
	public Student getStudentByName(@RequestParam("name") String name) {
		return service.getStudentByName(name);
	}

	@DeleteMapping("/removeStudent")
	public void deleteStudentByName(@RequestParam("name") String name) {
		service.deleteStudentByName(name);
	}
	
}
