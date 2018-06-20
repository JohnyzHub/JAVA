package com.corejava.design.patterns.singleton;

/**
 * @author johnybasha
 *
 */
public enum Animal {
	HORSE("Horse"), DOG("Dog"), CAT("Cat");

	String name;

	Animal(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	// Overriding HashCode and Equals methods are not allowed.
}
