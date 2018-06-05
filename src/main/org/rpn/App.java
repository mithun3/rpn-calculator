package org.rpn;

import java.util.Scanner;

import org.rpn.calculator.Engine;
import org.rpn.constants.Constants;


/**
 * 
 * @author 617150
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(Constants.WELCOME_MESSAGE);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String input = scanner.nextLine();
            try {
                Engine.evaluate(input, false);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            String output = Engine.getStack().isEmpty() ? "[Empty Stack]" : Engine.getStack().toString();
            System.out.println("Stack : " + output);
		}
	}
}