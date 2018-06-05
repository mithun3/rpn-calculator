package org.rpn.sample.poc;

import org.rpn.calculator.Calculator;
import org.rpn.calculator.UndoCalculator;

public class UndoCalculationMain {
	
	public static void main(String[] args) {
		System.out.println(Calculator.valueOf(Calculator.class, "PLUS"));
		System.out.println(Calculator.fromString("+").name());
		System.out.println(Calculator.fromString("+"));
		
		System.out.println(UndoCalculator.valueOf(Calculator.fromString("+").name()));
		
		System.out.println(Calculator.PLUS.toString());
		
		System.out.println(Calculator.lookup("PLUS"));
	}

}
