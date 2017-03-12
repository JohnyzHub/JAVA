package com.java8.features.extensionmethods;

public interface AdditionFormula {
	int add(int a, int b);

	default int performAddition(int a, int b) {
		return (a + b);
	}
}