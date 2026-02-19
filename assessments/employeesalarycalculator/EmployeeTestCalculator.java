package com.demo.employeesalarycalculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class EmployeeTestCalculator {
	static EmployeeSalaryCalculator esc;
	@Test
	public void testSalary()
	{
		esc = new EmployeeSalaryCalculator(20000,5000,10);
		assertTrue(esc.validateSalary());
		assertEquals(2000.0,esc.calculateDA());
		assertEquals(4000.0d,esc.calculateHRA());
		assertEquals(31000.0d,esc.calculateGrossSalary());
		assertEquals(27900.0d,esc.calculateNetSalary());
	}
	
	@Test
	public void testThrows()
	{
		esc = new EmployeeSalaryCalculator(0, 0, 100);
		assertThrows(IllegalArgumentException.class,() -> esc.validateSalary());
		assertThrows(IllegalArgumentException.class,() -> esc.validateSalary());
	}
}