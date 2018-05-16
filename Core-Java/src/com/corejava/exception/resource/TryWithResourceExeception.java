package com.corejava.exception.resource;

/**
 * @author johnybasha
 *
 */
public class TryWithResourceExeception {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (MyResource myresource = new MyResource(2, true)) {
			while (true) {
				myresource.use();
			}
		} catch (Exception e) {
			System.out.println("Exception thrown: " + e.getMessage());
			Throwable[] throwables = e.getSuppressed();
			if (throwables.length > 0) {
				System.out.println("Suppressed exceptions are: ");
			}
			for (Throwable throwable : throwables) {
				System.out.println(throwable.getMessage());
			}
		}
	}
}