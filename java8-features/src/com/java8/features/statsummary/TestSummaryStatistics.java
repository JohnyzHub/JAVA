/**
 * 
 */
package com.java8.features.statsummary;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

import com.java8.features.streams.Person;

/**
 * @author johnybasha
 *
 */
public class TestSummaryStatistics {

	public TestSummaryStatistics() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleSummaryStatistics doubleStats = new DoubleSummaryStatistics();
		doubleStats.accept(100.00);
		doubleStats.accept(150.00);
		doubleStats.accept(200.00);

		System.out.println(doubleStats);

		/**
		 * summarizingDouble(ToDoubleFunction<? super T> mapper)
		 * 
		 * Summarizing all the salaries of persons.
		 */
		DoubleSummaryStatistics incomeStats = Person.persons().stream()
				.collect(Collectors.summarizingDouble(Person::getIncome));
		System.out.println("Persons income stats: " + incomeStats);
	}

}
