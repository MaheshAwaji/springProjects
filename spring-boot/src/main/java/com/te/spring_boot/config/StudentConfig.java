package com.te.spring_boot.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.spring_boot.entity.Student;
import com.te.spring_boot.repository.StudentRepository;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args->{
			Student mahesh = new Student( "Mahesh", "mahi@gmail.com", LocalDate.of(2000, Month.APRIL, 12), 23);
			Student ramesh = new Student( "Ramesh", "ramesh@gmail.com", LocalDate.of(2002, Month.APRIL, 12), 25);
			
			repository.saveAll(List.of(mahesh,ramesh));
			
		};
	}

}
