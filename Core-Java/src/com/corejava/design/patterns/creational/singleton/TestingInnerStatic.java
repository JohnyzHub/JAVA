package com.corejava.design.patterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author johnybasha
 *
 */
public class TestingInnerStatic {

	public static void main(String[] args) {
		TestingInnerStatic test = new TestingInnerStatic();

		test.testObject();
		test.testingWithSerialization();
		test.testUsingReflection();

	}

	public void testObject() {
		InnerStaticClass instance1 = InnerStaticClass.getInstance();
		InnerStaticClass instance2 = InnerStaticClass.getInstance();
		System.out.println("\nTesting two instance objects: ");
		printResults(instance1, instance2);

	}

	public void testUsingReflection() {
		InnerStaticClass instance1 = InnerStaticClass.getInstance();
		InnerStaticClass instance2 = getInstanceUsingReflection();
		System.out.println("\nTesting two instance objects with reflection: ");
		printResults(instance1, instance2);

	}

	public InnerStaticClass getInstanceUsingReflection() {
		InnerStaticClass instance = null;
		try {
			Constructor<InnerStaticClass> constructor = InnerStaticClass.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			instance = constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return instance;
	}

	public void testingWithSerialization() {
		InnerStaticClass instance1 = InnerStaticClass.getInstance();
		InnerStaticClass instance2 = new ObjectSerialization<InnerStaticClass>().getSerializedObject(instance1);

		System.out.println("\nTesting two instance objects with serialization: ");
		printResults(instance1, instance2);
	}

	public void printResults(InnerStaticClass instance1, InnerStaticClass instance2) {
		if (instance1 == null || instance2 == null) {
			return;
		}

		System.out.println("instance1:hashcode-" + instance1.hashCode());
		System.out.println("instance2:hashcode-" + instance2.hashCode());

		System.out.println("instance1 == instance2: " + (instance1 == instance2));
		System.out.println("instance1 equals instance2: " + (instance1.equals(instance2)));
		System.out.println();
	}
}