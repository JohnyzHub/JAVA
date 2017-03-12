package com.java8.features.extensionmethods;

public class MathCalculations {

	public static void main(String[] args) {
		MathFormula formula = new MathFormula() {
			public int calculate(int a) {
				return (int) sqrt((double) (a * 100));
			}
		};

		System.out.println("Sqrt = " + formula.calculate(100));
		formula = (a) -> ((int) Math.sqrt((double) a * 100));
		System.out.println("Sqrt with lambda = " + formula.calculate(100));
		AdditionFormula addition = (a, b) -> (a + b);
		System.out.println("Addition With lambda (4+5) = " + addition.add(4, 5));
		System.out.println("Addition with static method (4+5) = " + addition.performAddition(4, 5));

	}
}
