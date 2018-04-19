package com.datastructures.stack;

import java.util.Enumeration;
import java.util.Stack;

public class MinFinder {

	private Stack<Integer> originalStack;

	private Stack<Integer> minStack;

	private int minNumber = 0;

	public MinFinder() {
		originalStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("" + number);
		}

		if (number < minNumber || originalStack.isEmpty()) {
			minNumber = number;
		}

		originalStack.push(number);
		minStack.push(minNumber);
	}

	public void pop() {
		originalStack.pop();
		minStack.pop();
	}

	public int getMinNumber() {
		return minStack.peek();
	}

	public void printAll() {
		Enumeration<Integer> enumerator = originalStack.elements();
		while (enumerator.hasMoreElements()) {
			System.out.println(enumerator.nextElement());
		}
		System.out.println("Min Number: " + minStack.peek());
	}
}
