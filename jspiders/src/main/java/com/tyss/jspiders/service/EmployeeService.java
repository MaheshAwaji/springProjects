package com.tyss.jspiders.service;

import java.util.List;

import com.tyss.jspiders.dto.EmployeeDTO;

public interface EmployeeService {

	String savaEmployee(EmployeeDTO dto);

	EmployeeDTO getEmployeeById(String employeeId);

	String deleteEmployeeById(String employeeId);

	EmployeeDTO updateEmployee(String employeeId, EmployeeDTO dto);

	List<EmployeeDTO> findAllEmployees();

	Boolean deleteAllEmployees();

	

	
}
