package org.rpn.calculator;

import org.rpn.sample.poc.DivideByZero;
import org.rpn.util.LookupUtil;

/**
 * an enum class which contains all the basic operations.
 * @author 617150
 *
 */
public enum Calculator {

	//Reversed the values from y + x to x + y as this was negating the output
	PLUS("+") {
		public double apply(double x, double y) {
			return y + x;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return y - x;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return y * x;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			if(x==0) {
				throw new ArithmeticException("Cannot perform a / by zero");
			}
			return y / x;
		}
	},
	SQRT("sqrt") {
		public double apply(double x, double y) {
			return Math.sqrt(x);
		}
	},
	POWER("power") {
		public double apply(double x, double y) {
			return Math.pow(x, 2);
		}
	},
	UNDO("undo") {
		public double apply(double x, double y) {
			throw new UnsupportedOperationException("The given input is either null or empty. ");
		}
	},
	CLEAR("clear") {
		public double apply(double x, double y) {
			throw new UnsupportedOperationException("The given input is either null or empty. ");
		}
	};

	//TODO : Put this in a super class and inherit from there
	@SuppressWarnings("rawtypes")
	public static Enum fromString(String text) {
		for (Calculator b : Calculator.values()) {
			if (b.symbol.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}

	private final String symbol;

	Calculator(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
	
	/**
	 * A simple enum look up method.
	 * @param id
	 * @return
	 */
	public static Calculator lookup(String id) {
		return LookupUtil.lookup(Calculator.class, id);
	}
	

	public abstract double apply(double x, double y);
}
