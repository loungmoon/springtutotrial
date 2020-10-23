package com.innoveller.demo.service;

import com.innoveller.demo.dto.BankAccountDto;
import com.innoveller.demo.model.BankAccount;
import com.innoveller.demo.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface BankService {
     BankAccount createAccount(BankAccountDto bank);

     BankAccount findAccount(Long id);

     void deposit(BankAccount account,double amount);

    //void withdraw(BankAccount account,double amount);
    //void transfer(BankAccount fromAccount,BankAccount toAccount,double amount);
    // void reportOfDateRange(Date from_date, Date to_date);
    // void reportForOneDay(Date date);


    //List<Transaction> getAccountTransactionList(BankAccount account);
    List<BankAccount> getAllBankAccount();

}
