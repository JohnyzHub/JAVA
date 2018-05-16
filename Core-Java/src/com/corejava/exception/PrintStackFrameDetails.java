package com.corejava.exception;

/**
 * @author johnybasha
 *
 */
public class PrintStackFrameDetails {

	public static void main(String[] args) {
		method1();
	}

	public static void method1() {
		method2();
	}

	public static void method2() {
		method3();
	}

	public static void method3() {
		Throwable t = new Throwable();
		printStackFrameDetails(t.getStackTrace());
	}

	public static void printStackFrameDetails(StackTraceElement[] frames) {
		int framesCount = frames.length;
		System.out.println("Frame count: " + framesCount);
		System.out.println("-------------------------------------\n");

		for (int index = 0; index < framesCount; index++) {
			System.out.println("Frame index: " + index);
			System.out.println("File name: " + frames[index].getFileName());
			System.out.println("Class name: " + frames[index].getClassName());
			System.out.println("Method name: " + frames[index].getMethodName());
			System.out.println("Line number: " + frames[index].getLineNumber());
			System.out.println("-------------------------------------");
		}
	}
}
