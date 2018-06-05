 package org.rpn.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EngineTest {
	boolean isUndoOperation = false;
	
	String inputExpression = null;
	@Before
	public void before() {
		Engine.getMemoryStack().clear();
		Engine.getStack().clear();
		isUndoOperation = false;
	}
	
	@After
	public void after() {
		//make everything null
		inputExpression = null;
		isUndoOperation = false;
	}
	
	@Test
	public void testNumericValueInStack() {
		inputExpression = "1 2 3";
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().get(0), 0);
		assertEquals(2, Engine.getStack().get(1), 0);
		assertEquals(3, Engine.getStack().get(2), 0);
	}
	
	@Test
	public void testSimpleAdd() {
		inputExpression = "1 2 +";
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
		assertEquals(3, Engine.getStack().get(0), 0);
	}
	
	@Test
	public void testSimpleSubtraction() {
		inputExpression = "1 2 -";
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
		assertEquals(-1, Engine.getStack().get(0), 0);
	}
	
	@Test
	public void testSimpleMultiplication() {
		inputExpression = "5 5 *";
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
		assertEquals(25, Engine.getStack().get(0), 0);
	}
	
	@Test
	public void testSimpleDivision() {
		inputExpression = "5 5 /";
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
		assertEquals(1, Engine.getStack().get(0), 0);
	}
	@Test (expected = ArithmeticException.class)
	public void testDivideByZero() {
		inputExpression = "1 0 /";
		Engine.evaluate(inputExpression, isUndoOperation);
	}
	
	@Test
	public void testPower() {
		inputExpression = "2 pow";
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
		assertEquals(2.0, Engine.getStack().get(0), 0);
	}
	
	@Test
	public void testSquareRoot() {
		inputExpression = "9 sqrt";
		boolean isUndoOperation = false;
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
		assertEquals(3, Engine.getStack().get(0), 0);
	}
	
	@Test
	public void testUndo() {
		inputExpression = "1 2 3 undo";
		boolean isUndoOperation = false;
		Engine.evaluate(inputExpression, isUndoOperation);
		assertEquals(2, Engine.getStack().size(), 0);
		Engine.evaluate("undo", isUndoOperation);
		assertEquals(1, Engine.getStack().size(), 0);
	}
	
	@Test
	public void testClear() {
		inputExpression = "1 2 3";
		String clear = "clear";
		Engine.evaluate(inputExpression, isUndoOperation);
		Engine.evaluate(clear, isUndoOperation);
		assertEquals(0, Engine.getStack().size(), 0);
	}
	
	//Negative Scenarios
    
//    @Rule
//    public ExpectedException expectedEx = ExpectedException.none();
//    @Test
//    public void testThrowExceptionWhenParamsNotSufficient() throws Exception {
//    	inputExpression = "1 2 + +";
//    	Engine.evaluate(inputExpression, isUndoOperation);
//    	expectedEx.expect(InvalidParameterException.class);
//        expectedEx.expectMessage("operator + (position: 4): insufficient parameters");
//    }
    
	@Test (expected = InvalidParameterException.class)
	public void testThrowExceptionWhenParamsNotSufficient() {
		try {
			inputExpression = "1 2 + +";
	    	Engine.evaluate(inputExpression, isUndoOperation);
		} catch (RuntimeException re) {
			String message = "operator + (position: 4): insufficient parameters";
			assertEquals(message, re.getMessage());
			throw re;
		}
		fail("operator + (position: 4): insufficient parameters");
	}
}
