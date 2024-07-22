package com.jspiders.jspiders_data_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class EmployeeDto {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private Float salary;
	private BankAccountDto bankAccount;

}
