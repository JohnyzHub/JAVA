package com.java8.features.lambdas;

import java.util.function.UnaryOperator;

public class LambdaRecursion {

	public int factorial(int number) {
		if (number < 0) {
			return 0;
		}

		if (number == 0) {
			return 1;
		}
		return number * factorial(number - 1);
	}

	public void printResult(int number) {
		UnaryOperator<Integer> recursionResult = this::factorial;
		int result = recursionResult.apply(number);
		System.out.println("Recursion of: " + number + " is : " + result);
	}

	public static void main(String args[]) {
		new LambdaRecursion().printResult(4);
	}
}
