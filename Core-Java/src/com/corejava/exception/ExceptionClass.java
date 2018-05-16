package com.corejava.exception;

/**
 * @author johnybasha
 *
 */
public class ExceptionClass {

	public void throwException() {
		throw new RuntimeException("This a test exception");
	}

	public void rethrowException1() {
		try {
			throwException();
		} catch (Exception e) {
			throw new RuntimeException("New Exception");
		}
	}

	public void rethrowException2() {
		try {
			throwException();
		} catch (Exception e) {
			throw new RuntimeException("New Exception", e);
		}
	}

	public void rethrowException3() {
		try {
			throwException();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void rethrowException4() {
		try {
			throwException();
		} catch (Exception e) {
			e.fillInStackTrace();
			throw new RuntimeException("New Exception", e);
		}
	}
}