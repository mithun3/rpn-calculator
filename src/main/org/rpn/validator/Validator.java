package org.rpn.validator;

import java.security.InvalidParameterException;
import java.util.EmptyStackException;

import org.rpn.calculator.Calculator;
import org.rpn.calculator.Engine;

/**
 * The validator class performs a set of basic validation before any calculation happens.
 * This is to ensure that all input provided is valid and no operation will fail or break during a calculation.
 * @author 617150
 *
 */
public class Validator {

	/**
	 * Checks if a given string is a valid operator or not by fetching the values from the Calculator Enum.
	 * @param operator	This is a string that contains the operator. ex: +, -, /, *, power, sqrt, undo, clear.
	 * 					Everything else apart from the above example is illegal.
	 * @return			Returns true if the given string is a legal operator else returns false.
	 */
	public static boolean isValidOperator(String operator) {
		for (Calculator op : Calculator.values()) {
			if (operator.equals(op.toString()))
				return true;
		}
		return false;
	}
	
	/**
	 * Simple check to find out if the stack is empty or not.
	 * @return 						true if stack is not empty.
	 * @throws EmptyStackException	if stack is empty this exception is thrown.
	 */
	public static boolean isStackEmpty() throws EmptyStackException {
		if (Engine.getStack().isEmpty()) {
			throw new EmptyStackException();
		}
		return true;
	}
	
	/**
	 * Checks if an operation is possible. i.e, check the number of operands required for a particular calculation.
	 * If the stack has lesser number of operands than required then an exception will occur.
	 * @param operator							ex: +, -, *, /, power, undo, clear
	 * @param count								
	 * @return
	 * @throws UnsupportedOperationException
	 */
	public static boolean isOperationPossible(String operator, int count) throws UnsupportedOperationException {
		if (Engine.getStack().size() < Validator.operandsRequired(operator)) {
			throw new InvalidParameterException(String.format("operator %s (position: %d): insufficient parameters", operator, count));
		}
		return true;
	}

	/**
	 * This method returns the number of operands required for a particular operation.
	 * 
	 * @param operator					ex: +, -, *, /, power, undo, clear.
	 * @return							retrun's the number of operands required based on the @param operator. 
	 * @throws RPNCalculationException 	this exception is thrown if an invalid operator is given.
	 */
	public static int operandsRequired(String operator) throws UnsupportedOperationException {
		int operandsRequired = 0;
		switch (Calculator.valueOf(Calculator.fromString(operator).name())) {
		case PLUS:
			operandsRequired = 2;
			break;
		case MINUS:
			operandsRequired = 2;
			break;
		case DIVIDE:
			operandsRequired = 2;
			break;
		case TIMES:
			operandsRequired = 2;
			break;
		case SQRT:
			operandsRequired = 1;
			break;
		case POWER:
			operandsRequired = 1;
			break;
		case UNDO:
			operandsRequired = 0;
			break;
		case CLEAR:
			operandsRequired = 0;
			break;			
		default:
			throw new UnsupportedOperationException("Not a valid operator. ");
		}
		return operandsRequired;
	}

}
