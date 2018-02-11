package com.java8.features.streams.collectors.andthen;

import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import com.java8.features.streams.Person;

/**
 * Collectors.collectingAndThen() is useful to apply a function on the resulted
 * collector.
 * 
 * @author johnybasha
 *
 */
public class CollectingAndThen {

	public static void main(String[] args) {
		System.out.println("Persons Collection: " + Person.persons() + "\n");

		/**
		 * First we collected a collection of person names and then applied a
		 * function to convert it to unmodifiable collection before returning
		 * the collection of names.
		 */
		Collection<String> personNames = Person.persons().stream().map(Person::getName)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println("Person Names: " + personNames);

		/**
		 * We need a map of months with names whose have birthdays in that
		 * month. 1) All the names of the months irrespective of any person has
		 * birthday in that month. 2) Months in sorted order. 3) Result
		 * immutable.
		 */

		Map<Month, String> groupNameByMonth = Person.persons().stream().collect(Collectors.collectingAndThen(
				Collectors.groupingBy(Person::getMonth, Collectors.mapping(Person::getName, Collectors.joining(", "))),
				result -> {
					for (Month m : Month.values()) {
						result.putIfAbsent(m, "None");
					}
					return Collections.unmodifiableMap(result);
				}));

		System.out.println("\nGroup person names, by their birth month: \n");
		groupNameByMonth.entrySet().forEach(System.out::println);

		/**
		 * An attempt to add or remove an item to the unmodifiable collection
		 * will throw UnsupportedOperationException as the collection is
		 * unmodifiable. Eg: personNames.add("Zen");
		 */

	}
}