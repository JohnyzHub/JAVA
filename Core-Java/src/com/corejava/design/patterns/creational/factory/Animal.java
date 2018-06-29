/**
 * 
 */
package com.corejava.design.patterns.creational.factory;

/**
 * @author johnybasha
 *
 */
public interface Animal {
	
	Animal createInstance();
	
	String makeSound();
	
	String getType();

}
