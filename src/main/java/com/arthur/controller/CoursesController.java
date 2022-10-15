package com.arthur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.model.Course;
import com.arthur.repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping
	public List<Course> list() {
		return courseRepository.findAll();
	}
	
}
