package com.datastructures.sort;

/**
 * @author johnybasha
 *
 */
public class ShellSort {
	private static int counter = 0;

	/**
	 * 
	 */
	public ShellSort() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[] { 5, 3, 9, 22, 43, 1, 6, 18, 15, 4, 2, 8, 7, 30, 25 };
		PrintJob.print(numbers);
		ShellSort.shellSort(numbers);

	}

	public static void shellSort(int[] numbers) {
		int size = 0;
		int increment = size = numbers.length;
		counter = 0;
		while ((increment = (increment / 2)) > 0) {
			System.out.println("\nIncrement Number: " + increment);
			for (int i = 0; i < increment; i++) {
				for (int j = i; j < size; j = j + increment) {
					for (int k = Math.min(j, size); k - increment >= 0; k = (k - increment)) {
						counter++;
						if (numbers[k] < numbers[k - increment]) {
							int temp = numbers[k];
							numbers[k] = numbers[k - increment];
							numbers[k - increment] = temp;
						} else {
							break;
						}
					}
				}

			}
		}
		new PrintJob().print(numbers);
		System.out.println("\nTotal Iterations :" + counter);
	}
}