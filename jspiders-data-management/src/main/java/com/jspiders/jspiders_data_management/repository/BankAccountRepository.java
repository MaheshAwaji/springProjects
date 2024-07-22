package com.jspiders.jspiders_data_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jspiders_data_management.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
