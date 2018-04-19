package com.datastructures.sort;

/**
 * @author johnybasha
 *
 */
public class PrintJob {

	/**
	 * 
	 */
	public PrintJob() {
		// TODO Auto-generated constructor stub
	}

	public static void print(int[] numbers) {
		int size = numbers.length;
		System.out.println();
		for (int index = 0; index < size; index++) {
			System.out.print(numbers[index] + ", ");
		}
	}

}
