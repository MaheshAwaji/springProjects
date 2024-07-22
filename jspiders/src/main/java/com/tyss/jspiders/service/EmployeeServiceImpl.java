package com.tyss.jspiders.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tyss.jspiders.dto.EmployeeDTO;
import com.tyss.jspiders.entity.BankAccount;
import com.tyss.jspiders.entity.Employee;
import com.tyss.jspiders.repository.EmployeeRepository;
import com.tyss.jspiders.utils.EmployeeUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Override
	public String savaEmployee(EmployeeDTO dto) {
		Employee employee = EmployeeUtils.convert(dto);
		employee.setEmployeeId(UUID.randomUUID().toString());
		return employeeRepository.save(employee).getEmployeeId();
	}

	@Override
	public EmployeeDTO getEmployeeById(String employeeId) {
		return EmployeeUtils.convert(
				employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Data not found")));
	}

	@Override
	public String deleteEmployeeById(String employeeId) {
		employeeRepository.deleteById(employeeId);
		return employeeId;
	}

	@Override
	public EmployeeDTO updateEmployee(String employeeId, EmployeeDTO dto) {
		// 1
		Employee employeeDB = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RuntimeException("Data not found"));
		// 2
		employeeDB.setFirstName(dto.getFirstName());
		employeeDB.setLastName(dto.getLastName());
		employeeDB.setSalary(dto.getSalary());
		employeeDB.setDateOfBirth(dto.getDateOfBirth());
		BankAccount bankAccount = employeeDB.getBankAccount();
		bankAccount.setIfsc(dto.getBankAccount().getIfsc());

		return EmployeeUtils.convert(employeeRepository.save(employeeDB));
	}

	

	@Override
	public List<EmployeeDTO> findAllEmployees() {
		List<Employee> all = employeeRepository.findAll();
		List<EmployeeDTO> dtos = EmployeeUtils.converList(all);
		return dtos;
	}

	@Override
	public Boolean deleteAllEmployees() {
		employeeRepository.deleteAll();
		return true;
	}

	
}
