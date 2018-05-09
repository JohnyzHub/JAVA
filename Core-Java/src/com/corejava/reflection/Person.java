package com.corejava.reflection;

/**
 * @author johnybasha
 *
 */
public abstract class Person implements Human {

	private String socialNumber = "12345";
	protected Gender gender;
	public long id = 1l;
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
