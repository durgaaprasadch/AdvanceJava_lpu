package com.demo.AgeValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AgeValidatorTest{
	
	@Mock
	Database db;
	
	@InjectMocks
	AgeValidator validator;
	
	@Test
	void testInvalidAge()
	{
//		assertThrows(IllegalArgumentException.class, () -> 
//				validator.validateAge(-1));
		doNothing().when(db).saveAge(anyInt());
	}
	
}