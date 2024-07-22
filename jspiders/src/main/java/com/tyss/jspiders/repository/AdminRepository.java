package com.tyss.jspiders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.jspiders.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
}
