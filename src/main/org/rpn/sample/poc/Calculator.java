package org.rpn.sample.poc;

public class Calculator {
	enum Operation {

		PLUS("+") {
			double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-") {
			double apply(double x, double y) {
				return x - y;
			}
		},
		TIMES("*") {
			double apply(double x, double y) {
				return x * y;
			}
		},
		DIVIDE("/") {
			double apply(double x, double y) {
				return x / y;
			}
		};

		private String symbol;

		Operation(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return symbol;
		}

		abstract double apply(double x, double y);
	}
	
	public static Enum fromString(String text) {
	    for (Operation b : Operation.values()) {
	      if (b.symbol.equalsIgnoreCase(text)) {
	        return b;
	      }
	    }
	    return null;
	  }

	public static void main(String[] args) {
		
		System.out.println(Calculator.fromString("+").name());
		System.out.println(Calculator.fromString("+"));
		System.out.println("/" == Operation.DIVIDE.toString());
//		double x = 2.0;
//		double y = 3.0;
//
//		for (Operation op : Operation.values()) {
//			System.out.print(x + " ");
//			System.out.print(op.toString() + " ");
//			System.out.print(y + " = ");
//			System.out.println(op.apply(x, y));
//		}
	}


	
	
}
