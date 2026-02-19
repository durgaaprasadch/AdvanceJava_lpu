package com.demo.Exceptions;

import org.junit.jupiter.api.extension.ExtendWith;


public class AgeValidator {

	public boolean validateAge(int age) {
        return age >= 18 && age <= 60;
    }

	
}
