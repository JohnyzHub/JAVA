package com.java8.features.streams.collectors.partitioning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8.features.streams.Person;

/**
 * Collectors.partitioning() always results a Map whose key is always a boolean
 * value.
 * 
 * @author johnybasha
 *
 */
public class Partitioning {

	public static void main(String[] args) {
		System.out.println("Persons Collection: " + Person.persons() + "\n");
		/*
		 * Partition the persons by gender: Male. The below code snippet results
		 * a map with key: boolean value: Person by partitioning on the basis of
		 * male gender.
		 */

		Map<Boolean, List<Person>> partitionByMale = Person.persons().stream()
				.collect(Collectors.partitioningBy(Person::isMale));

		System.out.println("PartitioningPersonsByMale: " + partitionByMale);

		/*
		 * Partition the person names by gender: Male. The below code snippet
		 * results a map with key: boolean value: Comma separated person name by
		 * partitioning on the basis of male gender.
		 */

		Map<Boolean, String> partitionNamesByGender = Person.persons().stream().collect(Collectors
				.partitioningBy(Person::isMale, Collectors.mapping(Person::getName, Collectors.joining(", "))));
		System.out.println("PartitioningPersonNamesByMaleGender: " + partitionNamesByGender);

	}
}
