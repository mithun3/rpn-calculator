package org.rpn.sample.poc;

import org.rpn.calculator.Calculator;

public class TestForSwitchCase {
	
	public static int operationalPrerequisites(String operator) throws UnsupportedOperationException {
		int operandsRequired = 0;
		switch (org.rpn.calculator.Calculator.valueOf(operator)) {
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
		default:
			throw new UnsupportedOperationException("Not a valid operator. ");
		}
		return operandsRequired;
	}
	
	public static void main(String[] args) {
//		System.out.println(operationalPrerequisites("PLUS"));
		System.out.println(Calculator.valueOf("+"));
	}

}
