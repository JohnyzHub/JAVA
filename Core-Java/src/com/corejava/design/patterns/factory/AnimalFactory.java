package com.corejava.design.patterns.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author johnybasha
 *
 */
public class AnimalFactory {

	private Map<String, Animal> animalMap = new HashMap<String, Animal>();

	private static class InstanceCreator {
		private static final AnimalFactory _instance = new AnimalFactory();
	}

	public static AnimalFactory getInstance() {
		return InstanceCreator._instance;
	}

	public void registerAnimal(String name, Animal animal) {
		animalMap.put(name, animal);
	}

	public Animal createAnimal(String name) {
		return animalMap.get(name).createInstance();
	}
}