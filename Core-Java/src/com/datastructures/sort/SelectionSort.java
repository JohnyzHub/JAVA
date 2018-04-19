package com.datastructures.sort;

/**
 * @author johnybasha
 *
 */
public class SelectionSort {

	/**
	 * 
	 */
	public SelectionSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SelectionSort sort = new SelectionSort();
		PrintJob printJob = new PrintJob();
		int[] numbers = new int[] { 5, 3, 9, 1, 6, 4, 2, 8, 7 };
		System.out.println("Before Sort: ");
		printJob.print(numbers);
		System.out.println();
		int size = numbers.length;
		int counter = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				counter++;
				if (numbers[j] < numbers[i]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
					System.out.print("\nIteration: " + counter + " :: ");
					printJob.print(numbers);
				}
			}
		}
	}
}