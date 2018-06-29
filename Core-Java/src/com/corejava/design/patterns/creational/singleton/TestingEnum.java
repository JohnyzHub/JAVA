package com.corejava.design.patterns.creational.singleton;

/**
 * @author johnybasha
 *
 */
public class TestingEnum {

	public static void main(String[] args) {
			TestingEnum test = new TestingEnum();
		test.testEnum();
	}

	public void testEnum() {
		Animal horse1 = Animal.HORSE;
		Animal horse2 = Animal.HORSE;

		System.out.println("Enum Equals test: " + horse1.equals(horse2));
		System.out.println("Enum == test: " + (horse1 == horse2));
		System.out.println("Hashcode: " + horse1 + " - " + horse1.hashCode());
		System.out.println("Hashcode: " + horse2 + " - " + horse2.hashCode());
	}

}
