package com.jspiders.jspiders_data_management.service;

import com.jspiders.jspiders_data_management.dto.EmployeeDto;

public interface EmployeeService {

	public String saveNewEmployee(EmployeeDto employeeDto);

	public EmployeeDto getEmployeeById(String empId);

}
