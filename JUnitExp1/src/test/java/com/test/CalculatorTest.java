package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest 
{
	Calculator calculator;
	
	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("before class");
	}
	
	@Before
	public void setUp()
	{
		System.out.println("before test");
		
		calculator = new Calculator();
	}
	
	@After
	public void setDown()
	{
		System.out.println("after test");
		
		calculator = null;
	}
	
	@Test
	public void testQube()
	{
		System.out.println("qube test");
		assertEquals(27, calculator.cube(3));
	}
	@Test
	public void testSquare()
	{
		System.out.println("square test");
		
		assertEquals(4.0, calculator.square(2.0), 4.0);
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("After class");
	}
}
