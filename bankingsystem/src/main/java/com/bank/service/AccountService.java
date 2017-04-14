package com.bank.service;

import java.util.List;

import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.InsufficientInitialBalanceException;
import com.bank.exceptions.InvalidAccountNumberException;
import com.bank.model.Account;


public interface AccountService {

	
  public Account createAccount(String customerName, double amount) throws InsufficientInitialBalanceException;
  public void depositeAmount(int accountNo,double amount) throws InvalidAccountNumberException;
  public double withdrawAmount(int accountNo,double amount) throws InvalidAccountNumberException, InsufficientBalanceException;
  public List<Account> getCustomerAccounts(int customerId);
  public Account getAccountDetailsById(int accountId);
  public void printAccountInfo(int accountNum);
	
	 
	


}
