package com.te.spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.spring_boot.entity.Student;
import com.te.spring_boot.service.StudentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
	private final StudentService studentService;
	
	@GetMapping
	public List<Student> getStudent() {
		return studentService.getStudents();
		
	}
	
	@PostMapping(path = "/addstudent")
	public void registerStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}
	
	@DeleteMapping( "/{studentId}")
	public void deleteStudent(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);
		
	}
	
	@PutMapping(path = "{studentId}")
	public void updatestudent(@ PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentService.updateStudent(studentId,name,email);
		
	}
	

}
