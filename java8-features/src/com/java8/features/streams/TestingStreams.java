package com.java8.features.streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.java8.features.streams.Person.Gender;

public class TestingStreams {

	public static void main(String[] args) {

		// testStrings();
		// testMapStringToInt();
		// testClosedRange();
		// testInfiniteRange();
		testFlatMap();
		// testGrouping();
		// testSerialVsParallel();

	}

	public static void testStrings() {
		String str = "1johny 2basha 3shaik";
		str.chars().filter(c -> (!(Character.isDigit((char) c) || Character.isWhitespace((char) c))))
				.forEach(c -> System.out.print((char) c));

		System.out.println();
		str = "Johny, Basha, Shaik";
		Pattern.compile(", ").splitAsStream(str).forEach(System.out::print);

	}

	public static void testMapStringToInt() {
		System.out.println("Obtain string lengths using mapToInt:: ");
		Stream.<String>of("FirstName", "LastName", "MiddleName").mapToInt(String::length).forEach(System.out::print);
		;
	}

	public static void testClosedRange() {
		int total = Stream.of(1, 2, 3, 5, 10, 4).filter(a -> (a % 2 != 0)).map(a -> a * a).reduce(0, Integer::sum);
		System.out.println("Obtain sum of numbers using reduce:: " + total);

		System.out.println("\nFind prime numbers from the range of 0 to 30:: \n");
		IntStream.rangeClosed(0, 30).filter(PrimeNumberUtil::isPrime).forEach(System.out::println);
	}

	public static void testInfiniteRange() {
		System.out.println();
		long count = IntStream.iterate(1, a -> a + 1).limit(100).filter(a -> (a % 2 == 0)).count();
		System.out.println("Testing Infinite Range: printing count of the first 100 even numbers::: " + count);

		System.out.println("Testing Infinite Range: printing 5 random numbers ::: ");
		new Random().ints().filter(a -> (a % 2 == 0)).limit(5).forEach(System.out::println);

		System.out.println("\nTesting Infinite Range: printing first 10 prime numbers beginning at 100::iterate::\n");
		LongStream.iterate(2l, PrimeNumberUtil::next).skip(100).limit(10).forEach(System.out::println);

		System.out.println("\nTesting Infinite Range: printing first 10 prime numbers beginning at 100::generate::\n");
		LongStream.generate(new PrimeNumberUtil()::next).skip(100).limit(10).forEach(System.out::println);
	}

	public static void testFlatMap() {
		List<Person> persons = Person.persons();

		// Find out count of developers with python skills*
		long pythonCount = persons.stream().map(Person::getLanguages).flatMap(Collection::stream)
				.filter(lang -> lang.equalsIgnoreCase("Python")).count();

		System.out.println("\nNumber of developers with Python skills: " + pythonCount);
	}

	public static void testGrouping() {
		List<Person> persons = Person.persons();
		Map<Gender, List<Person>> developersGenderMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		System.out.println("Developer Gender map: \n" + developersGenderMap);

		Map<Person.Gender, String> personGenderNameMap = Person.persons().stream().collect(Collectors
				.groupingBy(Person::getGender, Collectors.mapping(Person::getName, Collectors.joining(", "))));
		System.out.println("Person Gender-Name Map: " + personGenderNameMap);

	}

	public static void testSerialVsParallel() {
		long milliSeconds = System.currentTimeMillis();
		IntStream.rangeClosed(2, Integer.MAX_VALUE / 10).filter(a -> (a / 2 == 0)).count();
		System.out
				.println(String.format("Serial process took %d seconds", (System.currentTimeMillis() - milliSeconds)));

		milliSeconds = System.currentTimeMillis();
		IntStream.rangeClosed(2, Integer.MAX_VALUE / 10).parallel().filter(a -> (a / 2 == 0)).count();
		System.out.println(
				String.format("Parallel process took %d seconds", (System.currentTimeMillis() - milliSeconds)));
	}
}