package com.demo.calculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	
   private Calculator calculator = new Calculator();
   
	@Test
	void testSub() {
		 int result = calculator.sub(4, 2);
		 assertEquals(2, result);
	}
	
	@ParameterizedTest
	@CsvSource({"7,5,2","5,4,1"})
	
	void testSubtraction(int a, int b,int expected) {
		assertEquals(expected, calculator.sub(a, b)); 
	}
	
	@Test
	void testDiv() {
		int result = calculator.div(4, 1);
		assertEquals(4, result);
	}
	
	@Test
	void testAdd() {
		int result = calculator.add(5,5 );
		assertEquals(10, result);
		assertFalse(3>4);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 4, 6, 8})
	void testEvenNumbers(int num) {
	    assertTrue(num % 2 == 0);
	}


	@ParameterizedTest
	@CsvSource({"1,2,3","2,4,6","10,20,30"})
	
	void testAddition(int a,int b,int expected) {
		assertEquals(expected, calculator.add(a, b));
	}
	
	@Test
	void shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> calculator.div(40, 0) );
	}
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/DemoFile.csv", numLinesToSkip =0 )
	void AdditionFromFile(int a,int b, int expected) {
	    assertEquals(expected, calculator.add(a,b));
	}
}
