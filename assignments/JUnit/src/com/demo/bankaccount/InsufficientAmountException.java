package com.demo.bankaccount;

public class InsufficientAmountException extends Exception {

	public InsufficientAmountException(String message) {
		super(message);
	}
}
