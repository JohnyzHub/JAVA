package com.corejava.exception.resource;

/**
 * @author johnybasha
 *
 */
public class MyResource implements AutoCloseable {
	private int level;
	private boolean exceptionOnClose;

	public MyResource(int level, boolean excepionOnClose) {
		this.level = level;
		this.exceptionOnClose = excepionOnClose;
	}

	public void use() {
		if (level <= 0) {
			throw new RuntimeException("Low in level...");
		}
		System.out.println("Using MyResource level: " + level--);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.AutoCloseable#close()
	 */
	@Override
	public void close() {
		if (exceptionOnClose) {
			throw new RuntimeException("Error while closing resource.");
		}
		System.out.println("Resource closed.");
	}
}