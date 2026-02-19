package com.demo.bankaccount;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankAccountTest {

	BankAccount ba;
	
	@BeforeEach
	void setUp() {
	    ba = new BankAccount();
	}

	@Test
	public void testNegDeposit()  {
		assertThrows(InvalidAmountException.class, ()->{
			ba.deposit(-1);});
	}
	
	@Test
	public void testDeposit() throws InvalidAmountException {
		ba.deposit(1500);
		assertEquals(1500, ba.getBalance());
	}

	 @Test
	 public void testNegWithdraw() {
		 assertThrows(InvalidAmountException.class, ()->{ba.withdraw(-1);});
	 }
	 
	 @Test
	 public void testWithdraw() throws InvalidAmountException,InsufficientAmountException{
		 ba.deposit(500);
		 ba.withdraw(50);
		 assertEquals(450, ba.getBalance());
		 
	 }
	
	
}
