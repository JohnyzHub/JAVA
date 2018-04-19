package com.datastructures.sort;

/**
 * @author johnybasha
 *
 */
public class BubbleSort {

	PrintJob printJob = new PrintJob();

	/**
	 * 
	 */
	public BubbleSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		int[] numbers = { 5, 3, 9, 1, 6, 4, 2, 8, 7 };
		new PrintJob().print(numbers);
		System.out.println();

		sort.performSortTwo(numbers);

	}

	public void performSortTwo(int[] numbers) {
		boolean swapped = true;
		int size = numbers.length;
		int counter = 0;
		while (swapped) {
			swapped = false;
			for (int index = 0; index < size - 1; index++) {
				counter++;
				if (numbers[index] > numbers[index + 1]) {
					int temp = numbers[index];
					numbers[index] = numbers[index + 1];
					numbers[index + 1] = temp;
					printJob.print(numbers);
					swapped = true;
				}
			}
			size--;
			System.out.print(", Size - " + size);
		}
		System.out.print("\nIteration Count : " + counter);
	}

}