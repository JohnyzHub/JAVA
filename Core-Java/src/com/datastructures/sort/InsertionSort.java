package com.datastructures.sort;

/**
 * @author johnybasha
 *
 */
public class InsertionSort {

	/**
	 * Default Constructor
	 */
	public InsertionSort() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] numbers = { 5, 3, 9, 1, 6, 4, 2, 8, 7 };
		PrintJob printJob = new PrintJob();
		printJob.print(numbers);
		System.out.println();

		int counter = 0;
		int size = numbers.length;
		for (int i = 0; i < size; i++) {
			for (int j = i; (j - 1) >= 0; j--) {
				counter++;
				if (numbers[j] < numbers[j - 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j - 1];
					numbers[j - 1] = temp;
				} else {
					break;
				}
			}

		}
		printJob.print(numbers);
		System.out.println("\nTotal Iterations :" + counter);
	}

}
