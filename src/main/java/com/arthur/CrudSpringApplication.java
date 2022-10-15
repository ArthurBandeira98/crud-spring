package com.arthur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

//executa quando inicia a aplicação 
//	@Bean
//	CommandLineRunner initDataBase(CourseRepository courseRepository) {
//		return args -> {
//			courseRepository.deleteAll();
//						
//			List<Course> list = new ArrayList<>();
//			list.add(new Course(null, "TESTE", "TESTE"));
//			list.add(new Course(null, "TESTE", "TESTE"));
//			list.add(new Course(null, "TESTE", "TESTE"));
//			
//			for (Course course : list) {
//				courseRepository.save(course);				
//			}
//			
//		};
//	}

}
