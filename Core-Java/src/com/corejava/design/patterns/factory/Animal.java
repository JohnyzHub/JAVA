/**
 * 
 */
package com.corejava.design.patterns.factory;

/**
 * @author johnybasha
 *
 */
public interface Animal {
	
	Animal createInstance();
	
	String makeSound();
	
	String getType();

}
