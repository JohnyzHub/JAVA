package com.datastructures.sort;

/**
 * @author johnybasha
 *
 */
public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[] { 5, 3, 9, 22, 43, 1, 6, 18, 15, 4, 2, 8, 7, 30, 25 };
		PrintJob.print(numbers);
		mergeSort(numbers);
		System.out.println("\n\nAfter Merge :");
		PrintJob.print(numbers);
	}

	// https://codehs.gitbooks.io/apjava/content/Algorithms-and-Recursion/mergesort.html
	public static void mergeSort(int[] listToSort) {
		if (listToSort.length == 1) {
			return;
		}

		int size = listToSort.length;
		int midIndex = (size / 2) + (size % 2);
		int secondHalfSize = size - midIndex;
		int[] listFirstHalf = new int[midIndex];
		int[] listSecondHalf = new int[secondHalfSize];
		
		System.arraycopy(listToSort, 0, listFirstHalf, 0, midIndex);
		System.arraycopy(listToSort, midIndex, listSecondHalf, 0, secondHalfSize);
		//split(listToSort, listFirstHalf, listSecondHalf);

		mergeSort(listFirstHalf);
		mergeSort(listSecondHalf);

		merge(listToSort, listFirstHalf, listSecondHalf);

	}

	public static void split(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
		for (int firstIndex = 0; firstIndex < listFirstHalf.length; firstIndex++) {
			listFirstHalf[firstIndex] = listToSort[firstIndex];
		}

		int mainIndex = listFirstHalf.length;
		int secondIndex = 0;
		while (mainIndex < listToSort.length) {
			listSecondHalf[secondIndex++] = listToSort[mainIndex++];
		}
	}

	public static void merge(int[] listToSort, int[] listFirstHalf, int[] listSecondHalf) {
		int mergeIndex = 0;
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;

		System.out.println("\nList2Sort: ");
		PrintJob.print(listToSort);
		System.out.print("\nfirstHalf: ");
		PrintJob.print(listFirstHalf);
		System.out.print("\tsecondHalf: ");
		PrintJob.print(listSecondHalf);

		while (firstHalfIndex < listFirstHalf.length && secondHalfIndex < listSecondHalf.length) {
			if (listFirstHalf[firstHalfIndex] < listSecondHalf[secondHalfIndex]) {
				listToSort[mergeIndex] = listFirstHalf[firstHalfIndex];
				System.out.print("\n In firstHalf Block: ");
				PrintJob.print(listToSort);

				firstHalfIndex++;
			} else if (secondHalfIndex < listSecondHalf.length) {
				listToSort[mergeIndex] = listSecondHalf[secondHalfIndex];
				System.out.print("\n In secondHalf Block: ");
				PrintJob.print(listToSort);
				secondHalfIndex++;
			}
			mergeIndex++;
		}

		if (firstHalfIndex < listFirstHalf.length) {
			while (mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = listFirstHalf[firstHalfIndex++];
				System.out.print("\n In firstHalf Remain: ");
				PrintJob.print(listToSort);
			}
		}
		if (secondHalfIndex < listSecondHalf.length) {
			while (mergeIndex < listToSort.length) {
				listToSort[mergeIndex++] = listSecondHalf[secondHalfIndex++];
				System.out.print("\n In secondHalf Remain: ");
				PrintJob.print(listToSort);
			}
		}
		System.out.println("\n Merge :");
		PrintJob.print(listToSort);

	}
}