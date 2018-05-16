package com.corejava.exception;

/**
 * @author johnybasha
 *
 */
public class ExceptionRethrowExample {

	public static void main(String[] args) {
		ExceptionRethrowExample example = new ExceptionRethrowExample();
		example.testException1();
		example.testException2();
		example.testException3();
		example.testException4();

	}

	public void testException1() {
		try {
			new ExceptionClass().rethrowException1();
		} catch (Exception e) {
			System.out.println("\nexception(str)");
			e.printStackTrace();
		}
	}

	public void testException2() {
		try {
			new ExceptionClass().rethrowException2();
		} catch (Exception e) {
			System.out.println("\nexception(str, e)");
			e.printStackTrace();
		}
	}

	public void testException3() {
		try {
			new ExceptionClass().rethrowException3();
		} catch (Exception e) {
			System.out.println("\nexception(e)");
			e.printStackTrace();
		}
	}

	public void testException4() {
		try {
			new ExceptionClass().rethrowException4();
		} catch (Exception e) {
			System.out.println("\ne.fillInStackTrace()");
			e.printStackTrace();
		}
	}
}