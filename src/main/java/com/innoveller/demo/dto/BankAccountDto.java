package com.innoveller.demo.dto;

import java.sql.Date;

public class BankAccountDto {

    private Long id;

    private int accountNo;

    private String accountHolder;

    private String accountType;

    private Date opendate;

    private Double balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNo() {
        int accountNo = (int) (Math.random() * 100000000);
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getOpendate() {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date;
    }

    public void setOpendate(Date opendate) {
        this.opendate = opendate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
