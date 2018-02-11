package com.java8.features.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

	public static enum Gender {
		MALE, FEMALE
	}

	private long id;
	private String name;
	private Gender gender;
	private LocalDate dob;
	private double income;

	public Person(long id, String name, Gender gender, LocalDate dob, double income) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.income = income;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isFemale() {
		return this.gender == Gender.FEMALE;
	}

	public boolean isMale() {
		return this.gender == Gender.MALE;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Month getMonth() {
		return dob.getMonth();
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", income=" + income
				+ "]";
	}

	public static List<Person> persons() {
		List<Person> persons = new ArrayList<Person>(5);
		Person ken = new Person(1, "Ken", Gender.MALE, LocalDate.of(1982, Month.JULY, 10), 6000.00);
		Person ben = new Person(1, "ben", Gender.MALE, LocalDate.of(1980, Month.AUGUST, 20), 2000.00);
		Person sen = new Person(1, "sen", Gender.FEMALE, LocalDate.of(1986, Month.JULY, 15), 5000.00);
		Person pen = new Person(1, "pen", Gender.MALE, LocalDate.of(1981, Month.JANUARY, 05), 7000.00);
		Person fen = new Person(1, "fen", Gender.FEMALE, LocalDate.of(1984, Month.SEPTEMBER, 22), 6300.00);
		persons.addAll(Arrays.asList(ken, ben, sen, pen, fen));
		return persons;
	}

}
