package com.corejava.design.patterns.factory;

/**
 * @author johnybasha
 */
public class Dog implements Animal {

	static {
		AnimalFactory.getInstance().registerAnimal(AnimalType.DOG.name(), new Dog());
	}

	@Override
	public Animal createInstance() {
		return new Dog();
	}

	/*
	 * @see com.corejava.design.patterns.factory.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return "barking";
	}

	@Override
	public String getType() {
		return AnimalType.DOG.name();
	}
}