package com.te.spring_boot_jpa.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_boot_jpa.entity.Student;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	
	@GetMapping
	public List<Student> getStudent() {
		return List.of(new Student(2l, "Mahesh", "mahesh@gmail.com", LocalDate.of(2000, Month.FEBRUARY, 23), 23));
	}
	

}
