package com.arthur.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.arthur.model.Course;
import com.arthur.repository.CourseRepository;

@ActiveProfiles("test")
public class CourseServiceTest {
	
	@Mock
	private CourseRepository courseRepository;
	
	@Autowired
	@InjectMocks
	private CourseService courseService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("Should find Course by id Sucess")
	public void findByIdSucess() {
		Course course = new Course(1L, "Teste", "CategoryTest");
		
		when(courseService.findById(1L)).thenReturn(course);
		
	}

}
