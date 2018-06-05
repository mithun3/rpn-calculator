package org.rpn.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testPlusOperator() {
		assertEquals(Calculator.PLUS, Calculator.valueOf(Calculator.class, "PLUS"));
	}
	
	@Test
	public void testMinusOperator() {
		assertEquals(Calculator.MINUS, Calculator.valueOf(Calculator.class, "MINUS"));
	}
	
	@Test
	public void testTimesOperator() {
		assertEquals(Calculator.TIMES, Calculator.valueOf(Calculator.class, "TIMES"));
	}
	
	@Test
	public void testDivideOperator() {
		assertEquals(Calculator.DIVIDE, Calculator.valueOf(Calculator.class, "DIVIDE"));
	}
	
	@Test
	public void testSqrtOperator() {
		assertEquals(Calculator.SQRT, Calculator.valueOf(Calculator.class, "SQRT"));
	}
	
	@Test
	public void testPowerOperator() {
		assertEquals(Calculator.POWER, Calculator.valueOf(Calculator.class, "POWER"));
	}
	
	@Test
	public void testClearOperator() {
		assertEquals(Calculator.CLEAR, Calculator.valueOf(Calculator.class, "CLEAR"));
	}
	
	@Test
	public void testPlusOperatorEnum() {
		assertEquals("+", Calculator.fromString("+").toString());
	}
	
	@Test
	public void testMinusOperatorEnum() {
		assertEquals("-", Calculator.fromString("-").toString());
	}
	
	@Test
	public void testTimesOperatorEnum() {
		assertEquals("*", Calculator.fromString("*").toString());
	}
	
	@Test
	public void testDivideOperatorEnum() {
		assertEquals("/", Calculator.fromString("/").toString());
	}
	
	@Test
	public void testSqrtOperatorEnum() {
		assertEquals("sqrt", Calculator.fromString("sqrt").toString());
	}
	
	@Test
	public void testPowerOperatorEnum() {
		assertEquals("power", Calculator.fromString("power").toString());
	}
	
	@Test
	public void testClearOperatorEnum() {
		assertEquals("clear", Calculator.fromString("clear").toString());
	}
	
	@Test
	public void testLookupPlusOperator() {
		assertEquals("+", Calculator.lookup("PLUS").toString());
	}
	
	@Test
	public void testLookupMinusOperator() {
		assertEquals("-", Calculator.lookup("MINUS").toString());
	}
	
	@Test
	public void testLookupTimesOperator() {
		assertEquals("*", Calculator.lookup("TIMES").toString());
	}
	
	@Test
	public void testLookupDivideOperator() {
		assertEquals("/", Calculator.lookup("DIVIDE").toString());
	}
	
	@Test
	public void testLookupSqrtOperator() {
		assertEquals("sqrt", Calculator.lookup("SQRT").toString());
	}
	
	@Test
	public void testLookupPowerOperator() {
		assertEquals("power", Calculator.lookup("POWER").toString());
	}
	
	@Test
	public void testLookupClearOperator() {
		assertEquals("clear", Calculator.lookup("CLEAR").toString());
	}
	
}
