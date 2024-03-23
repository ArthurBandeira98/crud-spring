package com.arthur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.arthur.exception.RecordNotFoundException;
import com.arthur.model.Course;
import com.arthur.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> list() {
		return courseRepository.findAll();
	}
	
	public Course findById(@NotNull @Positive Long id) {
		return courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
	}

	public Course create(@Valid Course course) {
		return courseRepository.save(course);
	}
	
	public Course update(@NotNull @Positive Long id, @Valid Course course) {
		return courseRepository.findById(id).map(c -> {
			c.setName(course.getName());
			c.setCategory(course.getCategory());
			Course updated = courseRepository.save(c);
			return updated;
		}).orElseThrow(() -> new RecordNotFoundException(id));
	}
	
	public void delete(@PathVariable @NotNull @Positive Long id) {
		courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
	}
	
}
