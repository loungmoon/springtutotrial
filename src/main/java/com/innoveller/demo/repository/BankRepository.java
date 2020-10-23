package com.innoveller.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innoveller.demo.model.BankAccount;
 
@Repository
public interface BankRepository
        extends JpaRepository<BankAccount, Long> {
}
