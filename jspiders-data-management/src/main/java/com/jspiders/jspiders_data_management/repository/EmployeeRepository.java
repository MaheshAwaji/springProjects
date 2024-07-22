package com.jspiders.jspiders_data_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jspiders_data_management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
