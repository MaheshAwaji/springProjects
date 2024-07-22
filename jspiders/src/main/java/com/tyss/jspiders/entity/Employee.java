package com.tyss.jspiders.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Entity

public class Employee {
	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private Float salary;
	
	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	private BankAccount bankAccount;
}
