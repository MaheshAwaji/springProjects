package com.tyss.jspiders.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tyss.jspiders.dto.BankAccountDTO;
import com.tyss.jspiders.dto.EmployeeDTO;
import com.tyss.jspiders.entity.BankAccount;
import com.tyss.jspiders.entity.Employee;

public interface EmployeeUtils {

	public static Employee convert(EmployeeDTO dto) {

		return Employee.builder().dateOfBirth(dto.getDateOfBirth()).firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.bankAccount(BankAccount.builder().accountNumber(dto.getBankAccount().getAccountNumber())
						.ifsc(dto.getBankAccount().getIfsc()).build())
				.build();
	}

	public static EmployeeDTO convert(Employee employee) {

		return EmployeeDTO.builder().dateOfBirth(employee.getDateOfBirth()).firstName(employee.getFirstName())
				.lastName(employee.getLastName())
				.bankAccount(BankAccountDTO.builder().accountNumber(employee.getBankAccount().getAccountNumber())
						.ifsc(employee.getBankAccount().getIfsc()).build())
				.build();
	}

	public static List<EmployeeDTO> converList(List<Employee> all) {
		List<EmployeeDTO> dtos =  new ArrayList<EmployeeDTO>();
		Iterator<Employee> iterator = all.iterator();
		while(iterator.hasNext()){
			dtos.add(EmployeeUtils.convert(iterator.next()));
		}
		return dtos;
	}
}
