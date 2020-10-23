package com.innoveller.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="bank_account")
public class BankAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_no")
	private int accountNo;

	@Column(name = "account_holder")
	private String accountHolder;

	@Column(name = "account_type")
	private String accountType;

	@Column(name = "open_date")
	private Date opendate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNo() {
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
}