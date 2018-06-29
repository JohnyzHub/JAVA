package com.corejava.design.patterns.creational.factory;

/**
 * @author johnybasha
 *
 */
public class Horse implements Animal {

	static {
		AnimalFactory.getInstance().registerAnimal(AnimalType.HORSE.name(), new Horse());
	}

	static {
		AnimalFactory.getInstance().registerAnimal(AnimalType.HORSE.name(), new Horse());
	}

	@Override
	public String makeSound() {
		return "neigh";
	}

	@Override
	public String getType() {
		return AnimalType.HORSE.name();
	}

	@Override
	public Animal createInstance() {
		return new Horse();
	}
}
