package com.corejava.design.patterns.creational.factory;

/**
 * @author johnybasha
 *
 */
public class TestingFactoryPattern {

	public static void main(String args[]) {

		initializeClasses();

		Animal animal = AnimalFactory.getInstance().createAnimal(AnimalType.DOG.name());
		System.out.println("Animal - " + animal.getType() + " " + animal.makeSound());
		animal = AnimalFactory.getInstance().createAnimal(AnimalType.HORSE.name());
		System.out.println("Animal - " + animal.getType() + " " + animal.makeSound());

	}

	public static void initializeClasses() {
		try {
			Class.forName("com.corejava.design.patterns.factory.Dog", true, Dog.class.getClassLoader());
			Class.forName("com.corejava.design.patterns.factory.Horse", true, Horse.class.getClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
