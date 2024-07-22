package com.tyss.jspiders.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder

public class EmployeeDTO {

	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private Float salary;
	private BankAccountDTO bankAccount;
}
