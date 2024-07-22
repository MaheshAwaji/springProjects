package com.tyss.jspiders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.jspiders.entity.Employee;


// String because it is primary key in Employee class
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
