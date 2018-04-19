package com.datastructures.stack;

public class TestMinFinder {

	public static void main(String[] args) {
		MinFinder minFinder = new MinFinder();
		minFinder.push(10);
		minFinder.push(8);
		minFinder.push(9);
		minFinder.push(2);
		minFinder.push(6);
		minFinder.push(3);
		minFinder.push(5);
		System.out.println("Elements :");
		minFinder.printAll();
		minFinder.pop();
		System.out.println("Elements :");
		minFinder.printAll();
		minFinder.pop();
		minFinder.pop();
		minFinder.pop();
		System.out.println("Elements :");
		minFinder.printAll();
	}

}
