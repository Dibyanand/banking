package com.bank.exceptions;

public class InsufficientInitialBalanceException extends Exception {

	/**
	 * User: ddibyana
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientInitialBalanceException(String message){
		super(message);
	}
	
	

}
