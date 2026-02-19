package com.demo.UserRegistration;

public class AgeValidator {
	
	private Database db;
	
	public void validateAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("Age must not be negative");
		}
		db.saveAge(age);
	}


	

}
