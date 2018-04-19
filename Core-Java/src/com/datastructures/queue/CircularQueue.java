package com.datastructures.queue;

import java.lang.reflect.Array;

/**
 * @author johnybasha
 *
 */
public class CircularQueue<T> {

	private static final int SPECIAL_EMPTY_VALUE = -1;
	private static int MAX_SIZE = 40;
	private T[] elements;

	private int headIndex;
	private int tailIndex = headIndex = SPECIAL_EMPTY_VALUE;

	/**
	 *  
	 */
	public CircularQueue(Class<T> clazz) {
		elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}

	public boolean isEmpty() {
		return headIndex == SPECIAL_EMPTY_VALUE;
	}

	public boolean isFull() {
		int nextIndex = (tailIndex + 1) % elements.length;

		return nextIndex == headIndex;
	}

	public void enqueue(T data) {
		if (isFull()) {
			throw new RuntimeException("Queue is full.");
		}

		tailIndex = (tailIndex + 1) % elements.length;
		elements[tailIndex] = data;

		if (headIndex == SPECIAL_EMPTY_VALUE) {
			headIndex = tailIndex;
		}

	}

	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty.");
		}

		T data = elements[headIndex];

		if (headIndex == tailIndex) {
			headIndex = SPECIAL_EMPTY_VALUE;
		} else {
			headIndex = (headIndex + 1) % elements.length;
		}
		return data;
	}
	
}