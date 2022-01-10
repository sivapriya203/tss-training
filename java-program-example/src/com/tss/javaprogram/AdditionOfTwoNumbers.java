package com.tss.javaprogram;

import java.util.Scanner;

public class AdditionOfTwoNumbers {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter first number:");
		int firstNum = s.nextInt();
		System.out.println("Enter second number:");
		int secondNum = s.nextInt();
		System.out.println(add(firstNum, secondNum));
		s.close();
	}

	public static int add(int first, int second) {
		return first + second;
	}
}
