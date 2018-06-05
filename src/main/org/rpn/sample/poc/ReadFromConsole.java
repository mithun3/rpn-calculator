package org.rpn.sample.poc;

import java.io.Console;
import java.util.Scanner;

public class ReadFromConsole {
	
	public static void main(String[] args) {

//        Console console = System.console();
//        
//        System.out.println(console);
		
		
//		while (true) {
//
//            System.out.print("Enter something : ");
//            String input = System.console().readLine();
//
//            if ("q".equals(input)) {
//                System.out.println("Exit!");
//                System.exit(0);
//            }
//
//            System.out.println("input : " + input);
//            System.out.println("-----------\n");
//        }
//		
		
		//TODO: Error handling
		System.out.println("Enter your expression to be evaluated : ");
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
		    String s1 = scanner.next();
		    System.out.println("Expression is " + s1);
		}
	}
	
	

}
