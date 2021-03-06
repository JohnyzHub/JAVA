package com.java8.features.streams.collectors;

import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.java8.features.streams.Person;
import com.java8.features.streams.Person.Gender;

public class TestCollectors {

	public TestCollectors() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		testSummarizingXXX();
		testSummingXXX();
		testAvgingXXX();
		testCounting();
		testJoining();
		testMapping();
		testToMap();
		testGroupingBy();
		testPartitioning();
		testCollectAndThen();
	}

	public static void testSummarizingXXX() {
		/*-
		 * Person.getIncome() is double
		 * 
		 * Collectors.summarizingDouble(ToDoubleFunction<? super T> mapper) -.
		 */
		DoubleSummaryStatistics salaryStats = Person.persons().stream()
				.collect(Collectors.summarizingDouble(Person::getIncome));
		System.out.println("Salary Stats: " + salaryStats);
	}

	public static void testSummingXXX() {
		/*-
		 * Person.getIncome() is double.
		 * 
		 * Collectors.summingDouble(ToDoubleFunction<? super T> mapper)
		 */
		Double sumOfSalaries = Person.persons().stream().collect(Collectors.summingDouble(Person::getIncome));
		System.out.println("Sum of all Salaries: " + sumOfSalaries);
	}

	public static void testAvgingXXX() {
		/*-
		 * Person.getIncome() is double.
		 * 
		 * Collectors.averagingDouble(ToDoubleFunction<? super T> mapper)
		 */
		Double avgSalary = Person.persons().stream().collect(Collectors.averagingDouble(Person::getIncome));
		System.out.println("Avarage of all Salaries: " + avgSalary);
	}

	public static void testCounting() {
		/**
		 * Collectors.counting()
		 */

		long count = Person.persons().stream().collect(Collectors.counting());
		System.out.println("Count of Persons: " + count);
	}

	public static void testJoining() {
		/*-
		 * Collectors.joining()
		 */
		String names = Person.persons().stream().map(Person::getName).collect(Collectors.joining());
		System.out.println("Person Names without Delimiter: " + names);

		/*
		 * Collectors.joining(CharSequence delimiter)
		 */
		String namesWithDelimiter = Person.persons().stream().map(Person::getName).collect(Collectors.joining(","));
		System.out.println("Person Names without Delimiter: " + namesWithDelimiter);

		/*-
		 * Collectors.joining(
		 * 					CharSequence delimiter, 
		 * 					CharSequence prefix, 
		 * 					CharSequence suffix)
		 */
		String namesWithPrePostFix = Person.persons().stream().map(Person::getName)
				.collect(Collectors.joining(",", "Mr.", "-Jr"));
		System.out.println("Person Names without Pre/Postfix: " + namesWithPrePostFix);
	}

	public static void testMapping() {
		/*-
		 * Collectors.mapping(Function<? super T,? extends U> mapper, 
		 * 						Collector<? super U,A,R> downstream)
		 */
		List<String> personNames = Person.persons().stream()
				.collect(Collectors.mapping(Person::getName, Collectors.toList()));
		System.out.println("Person Names: " + personNames);

		String namesWithDelimiter = Person.persons().stream()
				.collect(Collectors.mapping(Person::getName, Collectors.joining(", ", "(", ")")));
		System.out.println("Names with delimiter: " + namesWithDelimiter);

		Optional<Double> maxIncome = Person.persons().stream()
				.collect(Collectors.mapping(Person::getIncome, Collectors.maxBy(Double::compareTo)));
		if (maxIncome.isPresent()) {
			System.out.println("Max Income: " + maxIncome);
		}
	}

	public static void testToMap() {
		/*-
		 * Collectors.toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
		 */
		Map<Long, String> personNameMap = Person.persons().stream()
				.collect(Collectors.toMap(Person::getId, Person::getName));

		System.out.println("Person names Map: " + personNameMap);

		/*-
		 * toMap(Function<? super T,? extends K> keyMapper, 
		 * 			Function<? super T,? extends U> valueMapper, 
		 * 			BinaryOperator<U> mergeFunction)
		 */

		Map<Gender, String> personGenderMap = Person.persons().stream()
				.collect(Collectors.toMap(Person::getGender, Person::getName, (a, b) -> String.join(", ", a, b)));
		System.out.println("Map : " + personGenderMap.getClass().getSimpleName() + " :: GenderMap: " + personGenderMap);

		Map<Gender, Person> maxIncomeByGender = Person.persons().stream().collect(Collectors.toMap(Person::getGender,
				Function.identity(), (a, b) -> (a.getIncome() > b.getIncome() ? a : b)));
		System.out.println("Max income by gender: " + maxIncomeByGender);

		/*-
		 * Collectors.toMap(Function<? super T,? extends K> keyMapper, 
		 * 			Function<? super T,? extends U> valueMapper, 
		 * 			BinaryOperator<U> mergeFunction, 
		 * 			Supplier<M> mapSupplier)
		 */

		Map<Gender, Double> incomeByGender = Person.persons().stream()
				.collect(Collectors.toMap(Person::getGender, Person::getIncome, Double::sum, TreeMap::new));
		System.out.println(
				"Map : " + incomeByGender.getClass().getSimpleName() + ":: Income by gender: " + incomeByGender);
	}

	public static void testGroupingBy() {
		/*-
		 * Collectors.groupingBy(Function<? super T,? extends K> classifier) 
		 */
		Map<Gender, List<Person>> groupByGender = Person.persons().stream()
				.collect(Collectors.groupingBy(Person::getGender));
		System.out.println("Grouping by Gender: " + groupByGender);

		/*-
		 * Collectors.groupingBy(Function<? super T,? extends K> classifier, 
		 * 						Collector<? super T,A,D> downstream)
		 */
		Map<Gender, Long> countingByGender = Person.persons().stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		System.out.println("Counting persons, Grouping by Gender: " + countingByGender);

		Map<Gender, List<String>> namesByGender = Person.persons().stream().collect(
				Collectors.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("Listing person names, Grouping by Gender: " + namesByGender);

		Map<Gender, DoubleSummaryStatistics> genderIncomeStats = Person.persons().stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.summarizingDouble(Person::getIncome)));
		System.out.println("Listing income stats, Grouping by Gender: " + genderIncomeStats);

		/*-
		 * Collectors.groupingBy(Function<? super T,? extends K> classifier, 
		 * 						Supplier<M> mapFactory, 
		 * 						Collector<? super T,A,D> downstream)
		 */

		Map<Gender, Map<Month, String>> birthDayMap = Person.persons().stream().collect(Collectors.groupingBy(
				Person::getGender, TreeMap::new,
				Collectors.groupingBy(Person::getMonth, Collectors.mapping(Person::getName, Collectors.joining(",")))));
		System.out.println("Map: " + birthDayMap.getClass().getCanonicalName()
				+ "\n\tListing person names, Grouping by Gender and BirthMonth: " + birthDayMap);
	}

	public static void testPartitioning() {
		/*-
		 * Collectors.partitioning() always results a Map 
		 * whose key is always a boolean value.
		 */

		/*-
		 * Collectors.partitioningBy(Predicate<? super T> predicate)
		 * 
		 * Partition the persons by gender: Male. 
		 * The below code snippet results a map with
		 * 		key: boolean value: Person 
		 * by partitioning on the basis of male gender.
		 */

		Map<Boolean, List<Person>> malePersons = Person.persons().stream()
				.collect(Collectors.partitioningBy(Person::isMale));
		System.out.println("List of Males : " + malePersons.get(true));

		/*-
		 * Collectors.partitioningBy(Predicate<? super T> predicate, 
		 * 								Collector<? super T,A,D> downstream)
		 * 
		 * Partition the person names by gender: Female. 
		 * The below code snippet results a map with
		 * 			key: boolean value: count of persons. 
		 * 			key: boolean value: Comma separated person name 
		 * by partitioning on the basis of female gender.
		 */
		Map<Boolean, Long> genderCountMap = Person.persons().stream()
				.collect(Collectors.partitioningBy(Person::isFemale, Collectors.counting()));
		System.out.println("Number of females : " + genderCountMap.get(true));

		Map<Boolean, String> namesByGenderMap = Person.persons().stream().collect(Collectors
				.partitioningBy(Person::isFemale, Collectors.mapping(Person::getName, Collectors.joining(", "))));
		System.out.println("Female names : " + namesByGenderMap.get(true));
	}

	public static void testCollectAndThen() {

		/*-
		 * collectingAndThen(Collector<T,A,R> downstream, Function<R,RR> finisher)
		 * 
		 * First we collected a collection of person names 
		 * and then applied a function to convert it to unmodifiable collection 
		 * 			before returning the collection of names.
		 */
		Collection<String> personNames = Person.persons().stream().map(Person::getName)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println("Person Names: " + personNames);

		/*-
		 * We need a map of months with names whose have birthdays in that month. 
		 * 	1) All the names of the months irrespective of any person 
		 * 			has birthday in that month. 
		 *  2) Months in sorted order. 
		 *  3) Result immutable.
		 */

		Map<Month, String> birthCalendar = Person.persons().stream().collect(Collectors.collectingAndThen(
				Collectors.groupingBy(Person::getMonth, Collectors.mapping(Person::getName, Collectors.joining(", "))),
				result -> {
					for (Month month : Month.values()) {
						result.putIfAbsent(month, "None");
					}
					return Collections.unmodifiableMap(new TreeMap<Month, String>(result));
				}));
		System.out.println("Names by BirthMonth(Print None if absent) : \n" + birthCalendar);
	}
}