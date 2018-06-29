package com.corejava.design.patterns.structural.composite;

/**
 * @author johnybasha
 *
 */
public class Developer extends Employee {

	public Developer(String name) {
		super(name);
	}

	@Override
	public void addReportee(Employee employee) {
		throw new RuntimeException("Operation not supported");
	}

	public void removeReportee(Employee employee) {
		throw new RuntimeException("Operation not supported");
	}

}
