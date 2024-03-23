package com.arthur.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthur.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
