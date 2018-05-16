package com.corejava.exception;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author johnybasha
 *
 */
public class PrintStackTraceExample {

	public static void main(String[] args) {
		PrintStackTraceExample example = new PrintStackTraceExample();
		example.printStackTrace();
		example.printStackTrace_printWriter();
		example.printStackTrace_printStream();
	}

	public void printStackTrace() {
		try {
			new ExceptionClass().throwException();
		} catch (Exception e) {
			System.out.println("\ne.printStackTrace():: ");
			e.printStackTrace();
		}
	}

	public void printStackTrace_printWriter() {
		try {
			new ExceptionClass().throwException();
		} catch (Exception e) {
			printStackTrace_writer(e);
		}
	}

	public void printStackTrace_printStream() {
		try {
			new ExceptionClass().throwException();
		} catch (Exception e) {
			printStackTrace_stream(e);
		}
	}

	public void printStackTrace_stream(Throwable e) {
		try (FileOutputStream fileStream = new FileOutputStream("FileChannelOut.txt");
				PrintStream printStream = new PrintStream(fileStream);) {
			e.printStackTrace(printStream);
		} catch (IOException e1) {
			printStackTrace_writer(e1);
		}
	}

	public void printStackTrace_writer(Throwable e) {
		System.out.println("\ne.printStackTrace(printWriter):: ");
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		System.out.println(stringWriter.toString());
	}
}