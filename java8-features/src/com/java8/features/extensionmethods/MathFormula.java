package com.java8.features.extensionmethods;

public interface MathFormula {

	int calculate(int a);

	default double sqrt(double a) {
		return Math.sqrt(a);
	}

	static int addition(int a, int b) {
		return (a + b);
	}

}
