package com.java8.features.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.java8.features.extensionmethods.AdditionFormula;

public class CollectionWithLambdas {

	public static void main(String[] args) {
		List<String> myStringCollection = Arrays.asList("Johny", "Basha", "Shaik", "Software", "Programmer");
		System.out.println("Collection : " + myStringCollection);
		Collections.sort(myStringCollection, (a, b) -> a.compareTo(b));
		System.out.println("Sorted Collection : " + myStringCollection);

		AdditionFormula addition = (a, b) -> (a + b);
		System.out.println("(10+20) = " + addition.add(10, 20));

	}

}
