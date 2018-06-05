package org.rpn.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.rpn.validator.Validator;

public class ValidatorTest {
	
	@Test
	public void testOperationPositive() {
		String inputExpression = "1 2";
		Engine.evaluate(inputExpression, false);
		assertEquals(true, Validator.isOperationPossible("+", 2));
	}
	
	@Test 
	public void testOperationNotPositive() {
		String inputExpression = "1";
		Engine.evaluate(inputExpression, false);
		assertEquals(true, Validator.isOperationPossible("+", 2));
	}
	
	@Test
	public void testOperandsRequiredForPlus() {
		assertEquals(2, Validator.operandsRequired("+"));
	}
	
	@Test
	public void testOperandsRequiredForMinus() {
		assertEquals(2, Validator.operandsRequired("-"));
	}
	
	@Test
	public void testOperandsRequiredForTimes() {
		assertEquals(2, Validator.operandsRequired("*"));
	}
	
	@Test
	public void testOperandsRequiredForDivide() {
		assertEquals(2, Validator.operandsRequired("/"));
	}
	
	@Test
	public void testOperandsRequiredForSqrt() {
		assertEquals(1, Validator.operandsRequired("sqrt"));
	}
	
	@Test
	public void testOperandsRequiredForPower() {
		assertEquals(1, Validator.operandsRequired("power"));
	}
	
	@Test
	public void testOperandsRequiredForUndo() {
		assertEquals(0, Validator.operandsRequired("undo"));
	}
	
	@Test
	public void testOperandsRequiredForClear() {
		assertEquals(0, Validator.operandsRequired("clear"));
	}

}
