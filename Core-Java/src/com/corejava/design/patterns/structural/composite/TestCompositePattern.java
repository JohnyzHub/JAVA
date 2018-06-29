package com.corejava.design.patterns.structural.composite;

/**
 * @author johnybasha
 *
 */
public class TestCompositePattern {

	public static void main(String[] args) {
		Employee developer1 = new Developer("Developer1");
		Employee developer2 = new Developer("Developer2");

		Employee manager1 = new Employee("Manager1");
		Employee manager2 = new Employee("Manager2");

		manager2.addReportee(developer1);
		manager2.addReportee(developer2);

		manager1.addReportee(manager2);

		manager1.printDetails();
	}
}