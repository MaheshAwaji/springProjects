package com.tyss.jspiders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.jspiders.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {


}
