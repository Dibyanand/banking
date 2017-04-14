/**
 * 
 */
package com.bank.dao;

import java.util.List;

import com.bank.model.Account;
import com.bank.model.Customer;

/**
 * @author ddibyana
 *
 */
public interface AccountDao {
	
	public Account createAccount(Customer customer, double amount);
	List<Account> findByCustomerId(int customerId);
	Account findByAccountNo(int accountNo);
	public void printAccountInfo(int accountNum);

}
