package com.demo.AgeValidator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AgeTest {
	@Test
	void test()
	{
		AgeValidation av = new AgeValidation();
		assertThrows(InvalidAgeException.class,() -> av.validate(17));
		assertThrows(IllegalArgumentException.class, () -> av.validate(-1));
		assertThrows(IllegalArgumentException.class, () -> av.validate(0));
	}
}