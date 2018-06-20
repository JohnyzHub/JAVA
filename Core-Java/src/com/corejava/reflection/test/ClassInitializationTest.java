package com.corejava.reflection.test;

import com.corejava.reflection.Employee;

/**
 * @author johnybasha
 *
 */
public class ClassInitializationTest {

	private static final String className = "com.corejava.reflection.Employee";

	public static void main(String[] args) {
		/**
		 * Invoke these methods one at a time to see the results.
		 */

		// createObject();
		// createObject_literal();
		// createObject_forName();
		// createObject_forName_false();
		createObject_forName_true();
	}

	public static void createObject() {
		System.out.println("new Employee(): Initializing..");
		new Employee();
	}

	public static void createObject_literal() {
		System.out.println("Person.class: Loading only");
		Class<Employee> c = Employee.class;
	}

	public static void createObject_forName() {
		System.out.println("Class.forName: Initializing..");
		try {
			Class.forName(className);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createObject_forName_false() {
		System.out.println("Class.forName: Loading Only");
		try {
			Class.forName(className, false, Employee.class.getClassLoader());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void createObject_forName_true() {
		System.out.println("Class.forName: Initializing");
		try {
			Class.forName(className, true, Employee.class.getClassLoader());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}