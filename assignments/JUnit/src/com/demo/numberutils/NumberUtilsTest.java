package com.demo.numberutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class NumberUtilsTest {
	
	private NumberUtils util = new NumberUtils();
	
	@ParameterizedTest
	@ValueSource(ints = {1,3,7})
	
	void checkOdd(int a) {
		assertEquals(true,util.isOdd(a));
	}
	
	@ParameterizedTest
	@CsvSource({
	    "Durga, DURGA",
	    "JUnit, JUNIT"
	})
	void testUpperCase(String input, String expected) {
	    assertEquals(expected, input.toUpperCase());
	}

	

}
