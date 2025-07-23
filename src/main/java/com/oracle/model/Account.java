package com.oracle.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component("account") //("account1")
@Scope(scopeName = "prototype")
@Primary //used for bean wala thing
@Entity //represents a table
@Table(name = "myaccount2")
public class Account {

	@Id
	@Column(name= "acc_Id")
	private int accountId;
	
	@Column(name = "bal")
	private double balance;
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}


	public Account() {
		System.out.println("Account object created!");
	}
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
