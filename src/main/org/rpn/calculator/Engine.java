package org.rpn.calculator;

import java.text.DecimalFormat;
import java.util.Stack;

import org.rpn.validator.Validator;

/**
 * This is the Engine class, its main function is to add the given operands into the stack.
 * Computations are added as an array into the memory stack so that they can be rolled back (undo) to a previous state.s
 * @author 617150
 *
 */
public class Engine {
	
	private static Stack<Double> stack = new Stack<Double>();
	private static Stack<String[]> memoryStack = new Stack<String[]>();
	private static int count = 0;
	//Format to 15 Decimal Place Precision
	static DecimalFormat fmt = new DecimalFormat("0.000000000000000");
			
	/**
	 * The input sting is split and processed one at a time.
	 * If it is numeric, it will be directly pushed into the Stack.
	 * Else, it will be assumed to be an operator and will be calulated against the values present in the stack.
	 * @param inputExpression					Is a series of string literals. ex: 1 2 3 + - 4 / 5 pow 6 sqrt
	 * @param isUndoOperation					This is a flag to specify that a particular calculation is an undo operation.
	 * @throws UnsupportedOperationException	Throws an exception if the given input is null or empty.
	 */
	public static void evaluate(String inputExpression, boolean isUndoOperation) throws UnsupportedOperationException{
		count = 0;
		if(inputExpression.isEmpty()) {
			throw new UnsupportedOperationException("The given input is either null or empty. ");
		}
		String[] splitResult = inputExpression.split("\\s");
		for(String value : splitResult){
			count++;
			//if numeric push to stack
			//else it must be an operator validate it
			if(isNumeric(value)){
				stack.push(Double.parseDouble(value));
				if(!isUndoOperation) {
					memoryStack.push(null);
				}
			}
			else{
				if (Validator.isValidOperator(value)) {
					Validator.isStackEmpty();
					Validator.isOperationPossible(value, count);
					calculate(value, isUndoOperation);
				}
			}
		}
	}
	
	/**
	 * The main calculation happens here.
	 * @param value				This is the operator, the calculation will happen based on the value of this operator.
	 * @param isUndoOperation	This is a flag to specify that a particular calculation is an undo operation.
	 * 							If this is true then the previous calculation will be rolled back / undone.
	 */
	private static void calculate(String value, boolean isUndoOperation) {
		
		if(value.equalsIgnoreCase(Calculator.UNDO.toString())) {
			undoPreviousCalculation();
			return;
		} else if (value.equalsIgnoreCase(Calculator.CLEAR.toString())) {
			clearStack();
			return;
		}
		double first = 0;
		double second = 0;
		if(Validator.operandsRequired(value)==1) {
			first = Engine.getStack().pop();
		} else if (Validator.operandsRequired(value)==2) {
			first = Engine.getStack().pop();
			second = Engine.getStack().pop();
		}
		
		Double result = Calculator.valueOf(Calculator.fromString(value).name()).apply(first, second);
		if (result != null) {
			stack.push(result);
			if(!isUndoOperation)
				memoryStack.push(new String[] {String.valueOf(first), value});
		}
	}

	/**
	 * This method straight away clears both the stacks.
	 */
	private static void clearStack() {
		Engine.getStack().clear();
		Engine.getMemoryStack().clear();
	}

	/**
	 * The previous calculation will be undone.
	 * The value from the memory stack will be read and the opposite calculation will be done to ascertain the original values.
	 * The original value is stored in the stack.
	 */
	private static void undoPreviousCalculation() {
		Validator.isStackEmpty();
		
		String[] lastTransaction = Engine.getMemoryStack().pop();
		
		if(lastTransaction == null) {
			Engine.getStack().pop();
		} else {
			prepareValuesForCalculation(lastTransaction);
		}
	}

	/**
	 * Values from the memory stack will be popped.
	 * These values contain the details of the previous calculation such as the operator and the operand.
	 * This along with the undo operator will be used to toll back to the previous state.
	 * @param lastTransaction	A String Array containing the operand and operator that was used in the previous calculation.
	 */
	private static void prepareValuesForCalculation(String[] lastTransaction) {
		int numberOfOperands = Validator.operandsRequired(lastTransaction[1]);
		String undoOperator = UndoCalculator.valueOf(Calculator.fromString(lastTransaction[1]).name()).toString();
		String expression = null;
		if (numberOfOperands == 0) {
			throw new UnsupportedOperationException();
		} else if (numberOfOperands == 1) {
			expression = String.format("%s %s", lastTransaction[0], undoOperator);
		} else if (numberOfOperands == 2) {
			expression = String.format("%s %s %s", lastTransaction[0], undoOperator, lastTransaction[0]);
		}
		evaluate(expression, true);
	}

	
	/**
	 * A simple utility method to check if a given string is numeric or not.
	 * @param value
	 * @return
	 */
	public static boolean isNumeric(String value) {
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static Stack<Double> getStack() {
		return stack;
	}

	public static Stack<String[]> getMemoryStack() {
		return memoryStack;
	}
}
