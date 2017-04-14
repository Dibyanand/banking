package com.bank.model;

public class Account {
	
	private int accountNumber;
	private double balance;
	private Customer customer;
	
	public Account(){}
	
	public Account(int accountNumber,double balance, Customer customer){
		this.accountNumber=accountNumber;
		this.balance=balance;
		this.customer=customer;
		
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer getCustomers() {
		return customer;
	}
	public void setCustomers(Customer customers) {
		this.customer = customers;
	}

}
