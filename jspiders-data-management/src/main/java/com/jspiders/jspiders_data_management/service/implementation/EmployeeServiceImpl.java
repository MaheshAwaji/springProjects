package com.jspiders.jspiders_data_management.service.implementation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jspiders.jspiders_data_management.dto.BankAccountDto;
import com.jspiders.jspiders_data_management.dto.EmployeeDto;
import com.jspiders.jspiders_data_management.entity.BankAccount;
import com.jspiders.jspiders_data_management.entity.Employee;
import com.jspiders.jspiders_data_management.exception.EmployeeNotFoundException;
import com.jspiders.jspiders_data_management.repository.BankAccountRepository;
import com.jspiders.jspiders_data_management.repository.EmployeeRepository;
import com.jspiders.jspiders_data_management.service.EmployeeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	@Override
	public String saveNewEmployee(EmployeeDto employeeDto) {
		Employee employee = Employee.builder().dateOfBirth(employeeDto.getDateOfBirth())
		.employeeId(UUID.randomUUID().toString()).firstName(employeeDto.getFirstName())
		.lastName(employeeDto.getLastName()).bankAccount(BankAccount.builder().accountNumber(employeeDto.getBankAccount().getAccountNumber())
				.ifsc(employeeDto.getBankAccount().getIfsc()).build()).build();
		
		employeeRepository.save(employee);
		return employee.getEmployeeId();
	}

	@Override
	public EmployeeDto getEmployeeById(String empId) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		if (employee.isPresent()) {
			Employee employee2 = employee.get();
			return EmployeeDto.builder().dateOfBirth(employee2.getDateOfBirth()).employeeId(employee2.getEmployeeId())
					.firstName(employee2.getFirstName()).lastName(employee2.getLastName())
					.salary(employee2.getSalary()).bankAccount(BankAccountDto.builder().accountNumber(employee2.getBankAccount().getAccountNumber())
							.ifsc(employee2.getBankAccount().getIfsc()).build()).build();
			
		}
		throw new EmployeeNotFoundException("Employee with id "+empId+" is not present");
	}

}
