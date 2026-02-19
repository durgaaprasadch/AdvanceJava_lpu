package com.demo.bankaccount;

public class BankAccount {

	private double balance;
	
	  public double getBalance() {
	        return balance;
	    }
	public void  deposit(double amount) throws InvalidAmountException {
		
		if(amount<0) {
			throw new InvalidAmountException("Amount must be positive");
		}
		this.balance +=amount;
	}
	
	public double withdraw(double withdraw) throws InsufficientAmountException,InvalidAmountException {
		
		if(balance<withdraw) {
			throw new InsufficientAmountException("Insufficient Amount.");
		}
		else if(withdraw<0) {
			throw new InvalidAmountException("Amount must be positive");
		}
		return balance-=withdraw;
		
	}
	

}
