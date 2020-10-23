package com.innoveller.demo.repository;

import com.innoveller.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionReposity extends JpaRepository<Transaction, Long> {
}
