/**
 * 
 */
package com.bank.service;

import java.util.List;

import com.bank.dao.AccountDao;
import com.bank.dao.AccountDaoImpl;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.InsufficientInitialBalanceException;
import com.bank.exceptions.InvalidAccountNumberException;
import com.bank.model.Account;
import com.bank.model.Customer;

/**
 * @author ddibyana
 *
 */
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	private int customerId=1001;
	

	public AccountServiceImpl(){
		accountDao=new AccountDaoImpl();
	}
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public Account createAccount(String customerName, double amount) throws InsufficientInitialBalanceException {
		if(amount<500)
		{
			throw new InsufficientInitialBalanceException("You have Insufficient Initial Balance");
		}
			
		Customer customer=new Customer(customerId, customerName);	
		customerId++;
			
		return accountDao.createAccount(customer, amount);
	}

	@Override
	public void depositeAmount(int accountNo, double amount) throws InvalidAccountNumberException {
		Account account = accountDao.findByAccountNo(accountNo);
		if(account==null){
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		double newBalance = account.getBalance() + amount;
		account.setBalance(newBalance);
	}

	@Override
	public double withdrawAmount(int accountNo, double amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		
		Account account = accountDao.findByAccountNo(accountNo);
		if(account==null){
			throw new InvalidAccountNumberException("Invalid Account Number");
		}
		if (amount > account.getBalance()) {
			throw new InsufficientBalanceException("Insufficient balance into your Account");
		}else {
			Double newBalance = account.getBalance() - amount;
			account.setBalance(newBalance);
			return account.getBalance();
		}
	}

	@Override
	public List<Account> getCustomerAccounts(int customerId) {
		List<Account> accountList= accountDao.findByCustomerId(customerId);
		return accountList;
	}

	@Override
	public Account getAccountDetailsById(int accountId) {
		Account account= accountDao.findByAccountNo(accountId);
		return account;
	}

	@Override
	public void printAccountInfo(int accountNum) {
		accountDao.printAccountInfo(accountNum);
		
	}

	
}
