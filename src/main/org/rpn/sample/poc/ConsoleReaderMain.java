package org.rpn.sample.poc;

import java.util.Scanner;

import org.rpn.calculator.Engine;

public class ConsoleReaderMain {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String input = scanner.nextLine();
			String[] splitResult = input.split("\\s");
            for(String s : splitResult) {
        	   System.out.println(s);
           }
		}
	}

}
