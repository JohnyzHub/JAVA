package com.corejava.reflection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author johnybasha
 *
 */
public class Employee<T, U> extends Person implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Initializing Employee class...");
	}

	public enum Department {
		FINANCE, ACCOUNTING;
	}

	private T id;
	private U name;
	private List<String> languagesKnown;
	public Department dept;

	private static final long serialVersionId = 100;

	public Employee() {
		initializeLanguages();
	}

	public Employee(T id, U name, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		initializeLanguages();
	}

	private void initializeLanguages() {
		this.languagesKnown = new ArrayList<String>(0);
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public U getName() {
		return name;
	}

	public void setName(U name) {
		this.name = name;
	}

	public List<String> getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(List<String> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	@Deprecated
	public boolean addLangualge(String language) throws Exception {
		this.languagesKnown.add(language);
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", languagesKnown=" + languagesKnown + ", gender=" + gender
				+ "]";
	}

	public Object clone(Object object) {
		Employee<T, U> clonedPerson = null;
		try {
			if (object == null || !(object instanceof Employee)) {
				throw new CloneNotSupportedException("Clone Not supported for : " + object.getClass());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		Employee<T, U> person = (Employee<T, U>) object;
		clonedPerson = new Employee<T, U>(person.getId(), person.getName(), person.getGender());

		return clonedPerson;
	}
}