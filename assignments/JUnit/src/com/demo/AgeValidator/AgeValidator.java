package com.demo.AgeValidator;

public class AgeValidator {
	private Database db;
	
	public AgeValidator(Database db)
	{
		this.db = db;
	}
	void validateAge(int age)
	{
		if(age<0)
			throw new IllegalArgumentException("Age cannot be negative");
		db.saveAge(age);
	}
}