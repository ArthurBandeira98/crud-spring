package com.arthur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arthur.model.Course;
import com.arthur.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

//executa quando inicia a aplicação 
	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
						
			List<Course> list = new ArrayList<>();
			list.add(new Course(null, "Java 17", "Back-end"));
			list.add(new Course(null, "Angular", "Back-end"));
			
			for (Course course : list) {
				courseRepository.save(course);				
			}
			
		};
	}

}
