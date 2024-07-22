package com.jspiders.jspiders_data_management.controller;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.jspiders_data_management.dto.EmployeeDto;
import com.jspiders.jspiders_data_management.entity.BankAccount;
import com.jspiders.jspiders_data_management.entity.Employee;
import com.jspiders.jspiders_data_management.response.SuccessResponse;
import com.jspiders.jspiders_data_management.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/jspiders")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@GetMapping("/dummy")
	public ResponseEntity<SuccessResponse> dummy(){
		return ResponseEntity.<SuccessResponse>ofNullable(SuccessResponse.builder().message("dummy")
				.status(HttpStatus.OK).timestamp(LocalTime.now()).data(Employee.builder()
						.bankAccount(BankAccount.builder().build()).build()).build());
	}
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<SuccessResponse> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		SuccessResponse successResponse = SuccessResponse.builder().message("Employee Added Successfully").status(HttpStatus.CREATED)
		.timestamp(LocalTime.now()).data(employeeService.saveNewEmployee(employeeDto)).build();
		
		return ResponseEntity.<SuccessResponse>ofNullable(successResponse);
		
	}
	
	@GetMapping(path = "{id}")
	public ResponseEntity<SuccessResponse> getEmployeeById(@PathVariable("id") String empId){
		SuccessResponse successResponse = SuccessResponse.builder().message("Employee Fetched Successfully").status(HttpStatus.OK)
		.timestamp(LocalTime.now()).data(employeeService.getEmployeeById(empId)).build();
		return ResponseEntity.<SuccessResponse>ofNullable(successResponse);
	}

}
