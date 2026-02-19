package com.demo.palindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

public class PalindromeTest {
	
	private Palindrome palindrome;
	
	@BeforeEach
	void testpalindrome() {
		palindrome = new Palindrome();
		boolean result = Palindrome.isPalindrome("hih");
		assertEquals(true,result);
	
		boolean result2 = Palindrome.isPalindrome("AbcbA");
		assertEquals(true,result2);
		
		boolean result20 = Palindrome.isPalindrome("AcbA");
		assertEquals(false,result2);
		
		
		
	}

}
