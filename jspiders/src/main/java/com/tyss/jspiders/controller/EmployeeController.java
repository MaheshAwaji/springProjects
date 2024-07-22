package com.tyss.jspiders.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.jspiders.dto.BankAccountDTO;
import com.tyss.jspiders.dto.EmployeeDTO;
import com.tyss.jspiders.response.SuccessResponse;
import com.tyss.jspiders.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = "api/employee")
@RestController
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping(path = "dummy")
	public ResponseEntity<SuccessResponse> dummy() {
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Dummy message").status(HttpStatus.OK).timestamp(LocalDateTime.now())
						.data((EmployeeDTO.builder().bankAccount(BankAccountDTO.builder().build()).build())).build());
	}

	@PostMapping(path = "")
	public ResponseEntity<SuccessResponse> saveEmployee(@RequestBody EmployeeDTO dto) {
		System.out.println(dto);
		// String id = employeeService.savaEmployee(dto);
		SuccessResponse successResponse = SuccessResponse.builder().message("Employee data saved succesfully")
				.status(HttpStatus.CREATED).timestamp(LocalDateTime.now()).data(employeeService.savaEmployee(dto))
				.build();
		return ResponseEntity.<SuccessResponse>ofNullable(successResponse);

	}

	@GetMapping(path = "")
	public ResponseEntity<SuccessResponse> getEmployeeById(@RequestParam(name = "id") String employeeId) {

		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Employee data fetched succesfully").status(HttpStatus.OK)
						.timestamp(LocalDateTime.now()).data(employeeService.getEmployeeById(employeeId)).build());

	}

	@DeleteMapping(path = "")
	public ResponseEntity<SuccessResponse> deleteEmployeeById(@PathVariable(name = "id") String employeeId) {
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("Employee data deleted succesfully").status(HttpStatus.OK)
						.timestamp(LocalDateTime.now()).data(employeeService.deleteEmployeeById(employeeId)).build());

	}

	@PutMapping(path = "")
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestParam(name = "id") String employeeId,
			@RequestBody EmployeeDTO dto) {

		EmployeeDTO updateDTO = employeeService.updateEmployee(employeeId, dto);
		return ResponseEntity.<SuccessResponse>ofNullable(SuccessResponse.builder().message("Employee data provided")
				.status(HttpStatus.OK).timestamp(LocalDateTime.now()).data(updateDTO).build());
	}
	@GetMapping(path = "findAll")
	public ResponseEntity<SuccessResponse> getAllEmployee() {
	 List<EmployeeDTO>  dtos =	employeeService.findAllEmployees();
		return ResponseEntity.<SuccessResponse>ofNullable(
				SuccessResponse.builder().message("All Employees data fetched succesfully").status(HttpStatus.OK)
						.timestamp(LocalDateTime.now()).data(dtos).build());

	}
	
	@DeleteMapping(path = "deleteAll")
	public ResponseEntity<SuccessResponse> deleteAllEmployee() {
		 Boolean isDeleted =	employeeService.deleteAllEmployees();
			return ResponseEntity.<SuccessResponse>ofNullable(
					SuccessResponse.builder().message("Employee data fetched succesfully").status(HttpStatus.OK)
							.timestamp(LocalDateTime.now()).data(isDeleted).build());

		}
	
}
