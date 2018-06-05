package org.rpn.sample.poc;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class EnumCalculatorMain {
	
	public static void main(String[] args) {
//        double result = EnumCalculator.PLUS.calculate(1, 2);
//        System.out.println(result); //3.0
		String s= "/";
		System.out.println(s == Calculator.Operation.DIVIDE.toString());
	}
	
}
