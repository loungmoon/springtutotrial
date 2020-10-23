package com.innoveller.demo.service;
import com.innoveller.demo.dto.BankAccountDto;
import com.innoveller.demo.model.BankAccount;
import com.innoveller.demo.model.Transaction;
import com.innoveller.demo.repository.BankRepository;
import com.innoveller.demo.repository.TransactionReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private TransactionReposity transactionReposity;

    public void saveTransaction(double amount, String transactionType, BankAccount bank) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionDate(transaction.getTransactionDate());
        transaction.setTransactionType(transactionType);
        transaction.setBankAccount(bank);
        transactionReposity.save(transaction);
    }

//    public double calculatedTotalBalance(Long bank_account_id) {
//        List<Transaction> transactionList = new ArrayList<>();
//        double totalAmount = 0.0;
//        try {
//            Query query =transactionReposity.("FROM Transaction  WHERE bankAccount.id = ?1");
//            query.setParameter(1,bank_account_id);
//            transactionList  =  query.getResultList();
//        }catch (Exception ex){
//            System.out.println("Exception Error !!");
//            ex.printStackTrace();
//        }
//        for (Transaction transaction : transactionList) {
//            if (transaction.getTransactionType().equals("DEPOSIT")) {
//                totalAmount += transaction.getAmount();
//            } else if (transaction.getTransactionType().equals("WITHDRAW")) {
//                totalAmount -= transaction.getAmount();
//            } else {
//                totalAmount -= transaction.getAmount();
//            }
//        }
//        return totalAmount;
//    }
//


    public BankAccount findAccount(Long id) {
        Optional< BankAccount > optional = bankRepository.findById(id);
        BankAccount account = null;
        if (optional.isPresent()) {
            account = optional.get();
        } else {
            throw new RuntimeException(" Account not found for id :: " + id);
        }
        return account;
    }

    public BankAccount createAccount(BankAccountDto bank) {

        BankAccount account = new BankAccount();

        account.setAccountHolder(bank.getAccountHolder());
        account.setAccountNo(bank.getAccountNo());
        account.setAccountType(bank.getAccountType());
        account.setOpendate(bank.getOpendate());
        this.bankRepository.save(account);

        saveTransaction(bank.getBalance(),"DEPOSIT",account);

        return  account;
    }

    @Override
    public void deposit(BankAccount account, double amount) {
        saveTransaction(amount,"DEPOSIT",account);
    }

    //
//    public void withdraw(BankAccount account, double amount) {
//        em.getTransaction().begin();
//        try {
//            double totalBalance = calculatedTotalBalance(account.getId());
//            if (totalBalance > amount) {
//                saveTransaction(amount, "WITHDRAW", account
//                );
//            }else{
//                System.out.println("Cannot Withdraw !! You balance have "+totalBalance);
//            }
//        }catch (Exception ex){
//            System.out.println("Exception Error !!");
//        }
//        em.getTransaction().commit();
//    }
//
//    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount) {
//        em.getTransaction().begin();
//        try {
//            double totalAmount = calculatedTotalBalance(fromAccount.getId());
//            if (totalAmount > amount) {
//                saveTransaction(amount,"TRANSFER", fromAccount);
//                saveTransaction(amount, "DEPOSIT", toAccount);
//            }
//            else {
//                System.out.println("Cannot Transfer !! You balance have "+totalAmount);
//            }
//        } catch (Exception e) {
//            System.out.println("Exception Error !!");
//            e.printStackTrace();
//        }
//        em.getTransaction().commit();
//    }
//
//    public List<Transaction> getAccountTransactionList(BankAccount account) {
//        List<Transaction> transactionList = new ArrayList<>();
//        try {
//            Query query =em.createQuery("FROM Transaction  WHERE bankAccount.id = ?1");
//            query.setParameter(1,account.getId());
//            transactionList  =  query.getResultList();
//        }  catch (Exception e) {
//            System.out.println("Exception Error !!");
//        }
//        return transactionList;
//    }
//

    public List<BankAccount> getAllBankAccount() {
        List<BankAccount> bankAccountList =bankRepository.findAll();

        if(bankAccountList.size() > 0) {
            return bankAccountList;
        } else {
            return new ArrayList<BankAccount>();
        }
    }
//
//    public void reportOfDateRange(Date from_date, Date to_date) {
//        List<Transaction> transactionList = new ArrayList<>();
//        try {
//            Query query =em.createQuery("from Transaction where transactionDate BETWEEN :fromdate and :todate");
//            query.setParameter("fromdate", from_date);
//            query.setParameter("todate", to_date);
//            transactionList = query.getResultList();
//
//        } catch (Exception ex) {
//            System.out.println("Exception Error !!");
//        }
//        for(Transaction transaction:transactionList){
//            System.out.println("Transaction Type :"+transaction.getTransactionType() + " Amount : " + transaction.getAmount());
//        }
//    }
//
//    public void reportForOneDay(Date date) {
//        List<Transaction> transactionList = new ArrayList<>();
//        try {
//            Query query = em.createQuery("from Transaction where transactionDate= ?1");
//            query.setParameter(1,date);
//            transactionList = query.getResultList();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        for(Transaction transaction:transactionList){
//            System.out.println("Transaction Type :"+transaction.getTransactionType() + " Amount : " + transaction.getAmount());
//        }
//    }
//

}
