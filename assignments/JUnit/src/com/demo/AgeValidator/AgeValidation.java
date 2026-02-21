package com.demo.AgeValidator;

public class AgeValidation {
	public void validate(int age) throws InvalidAgeException, IllegalArgumentException
	{  
		if(age<=0)
			throw new IllegalArgumentException();
		if(age<18)
			throw new InvalidAgeException("Invalid Age");
	}
}