package com.arthur.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.model.Course;
import com.arthur.repository.CourseRepository;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CoursesController {

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public List<Course> list() {
		return courseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable @NotNull @Positive Long id) {
		return courseRepository.findById(id).map(c -> ResponseEntity.ok(c)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Course> create(@RequestBody @Valid Course course) {
		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {
		return courseRepository.findById(id).map(c -> {
			c.setName(course.getName());
			c.setCategory(course.getCategory());
			Course updated = courseRepository.save(c);
			return ResponseEntity.ok(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable @NotNull @Positive Long id) {
		return courseRepository.findById(id).map(c -> {
			courseRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
