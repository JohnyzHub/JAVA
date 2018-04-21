/**
 * 
 */
package com.java8.features.streams.collect;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

import com.java8.features.streams.Person;

/**
 * @author johnybasha
 *
 */
public class TestStreamCollect {

	/**
	 * 
	 */
	public TestStreamCollect() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * collect(Supplier<R> supplier, BiConsumer<R,? super T> accumulator,
		 * BiConsumer<R,R> combiner)
		 */
		StringBuilder stringBuilder = Person.persons().stream().map(Person::getName).collect(() -> new StringBuilder(),
				(strBuilder, name) -> strBuilder.append(name + ", "),
				(strBuilder1, strBuilder2) -> strBuilder1.append(strBuilder2));
		System.out.println("....StringBuilder:: \n" + stringBuilder);

		DoubleSummaryStatistics doubleStats = Person.persons().stream().map(Person::getIncome).collect(
				DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
		System.out.println("....DoubleSummaryStatistics:: \n" + doubleStats.getSum());

		doubleStats = Person.persons().stream().map(Person::getIncome).collect(() -> new DoubleSummaryStatistics(),
				(a, b) -> a.accept(b), (a, b) -> a.combine(b));
		System.out.println("....DoubleSummaryStatistics:: \n" + doubleStats.getSum());

		/**
		 * collect(Collector<? super T,A,R> collector)
		 */
		System.out.println("\n....Collector::");
		Person.persons().stream().map(p -> p.getName()).collect(Collectors.toList()).forEach(System.out::println);

	}

}
