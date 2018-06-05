package org.rpn.calculator;

public enum UndoCalculator {

	PLUS("-") {
		double apply(double x, double y) {
			return x - y;
		}
	},
	MINUS("+") {
		double apply(double x, double y) {
			return x + y;
		}
	},
	TIMES("/") {
		double apply(double x, double y) {
			return x / y;
		}
	},
	DIVIDE("*") {
		double apply(double x, double y) {
			return x * y;
		}
	},
	POW("sqrt") {
		double apply(double x, double y) {
			return x * y;
		}
	},
	SQRT("pow") {
		double apply(double x, double y) {
			return x * y;
		}
	};
	
	private final String symbol;
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	//TODO : Put this in a super class and inherit from there
	public static Enum fromString(String text) {
		for (UndoCalculator b : UndoCalculator.values()) {
			if (b.symbol.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
	
	UndoCalculator(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	abstract double apply(double x, double y);
}
