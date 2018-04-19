package com.datastructures.queue;

/**
 * @author johnybasha
 *
 */
public class TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CircularQueue<String> circularQueue = new CircularQueue<String>(String.class);
		circularQueue.enqueue("Michigan");
		circularQueue.enqueue("Ohio");
		circularQueue.enqueue("Indiana");
		circularQueue.enqueue("Chicago");

		System.out.println(circularQueue.dequeue());
		System.out.println(circularQueue.dequeue());
	}
}