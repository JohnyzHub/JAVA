package com.corejava.design.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author johnybasha
 *
 */
public class Employee {

	private List<Employee> reportees;

	private String name;

	public Employee(String name) {
		this.name = name;
	}

	private boolean reporteesExist() {
		if (reportees == null || reportees.isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean reporteesNotExist() {
		return !reporteesExist();
	}

	public void addReportee(Employee employee) {
		if (this.equals(employee)) {
			throw new RuntimeException("Operation failed");
		}

		if (reporteesNotExist()) {
			reportees = new ArrayList<Employee>(1);
		}
		reportees.add(employee);
	}

	public void removeReportee(Employee employee) {
		if (reporteesNotExist()) {
			return;
		}
		reportees.remove(employee);
	}

	public void printDetails() {
		System.out.println(this);
		if (reporteesNotExist()) {
			return;
		}
		System.out.println("Reportees: ");
		reportees.forEach(r -> r.printDetails());
	}

	@Override
	public String toString() {
		return "Employee [" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
