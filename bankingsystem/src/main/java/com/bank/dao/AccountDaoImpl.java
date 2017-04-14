/**
 * 
 */
package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.Customer;

/**
 * @author ddibyana
 *
 */
public class AccountDaoImpl implements AccountDao {
	private int accountNumber;
	private Account[] accounts;
	private int numOfAccounts;  
	
	public AccountDaoImpl(){
		accountNumber=562345;
		accounts=new Account[100];
		numOfAccounts=0;
	}

	@Override
	public Account createAccount(Customer customer, double amount) {
		Account account =new Account(accountNumber, amount, customer);
		accounts[numOfAccounts] = account;
		numOfAccounts++;
		accountNumber++;
		return account;
	}

	@Override
	public List<Account> findByCustomerId(int customerId) {
		List accountList=new ArrayList<>();
		for (int i = 0; i < numOfAccounts; i++) {
			if (customerId == accounts[i].getCustomers().getCustomerId()) {
				accountList.add(accounts[i]);
			}
		}
		return accountList;
	

	}

	@Override
	public Account findByAccountNo(int accountNo) {
		List accountList=new ArrayList<>();
		for (int i = 0; i < numOfAccounts; i++) {
			if (accountNo == accounts[i].getAccountNumber()) {
				return accounts[i];
			}
		}
		return null;
	}
	
	@Override
	public void printAccountInfo(int accountNum) {
		for (int i = 0; i < numOfAccounts; i++) {
			if (accountNum == accounts[i].getAccountNumber()) {
				System.out.println(accounts[i].getBalance());
				System.out.println(accounts[i].getCustomers().getCustomerId());
				System.out.println(accounts[i].getCustomers().getCustomerName());

			}
		}

	}



}
