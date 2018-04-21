package com.java8.features.streams.reduce;

import com.java8.features.streams.Person;

/**
 * @author johnybasha
 *
 */
public class TestStreamReduce {

	/**
	 * 
	 */
	public TestStreamReduce() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * reduce(BinaryOperator<T> accumulator)
		 */
		Person.persons().stream().map(Person::getIncome).reduce(Double::sum).ifPresent(System.out::println);

		/**
		 * reduce(T identity, BinaryOperator<T> accumulator)
		 */
		double totalSalary = Person.persons().stream().map(Person::getIncome).reduce(0d, Double::sum);
		System.out.println("2.Total Salary: " + totalSalary);
		totalSalary = 0;

		/**
		 * reduce(U identity, BiFunction<U,? super T,U> accumulator,
		 * BinaryOperator<U>combiner)
		 */
		totalSalary = Person.persons().stream().reduce(0d, (a, p) -> (a + p.getIncome()), (a, b) -> {
			System.out.println("a= " + a + ", b= " + b + ", a+b= " + (a + b));
			return a + b;
		});
		System.out.println("3.Total Salary: " + totalSalary + "\n");
		totalSalary = 0;

		totalSalary = Person.persons().parallelStream().reduce(0d, (s, p) -> {
			System.out.println(Thread.currentThread().getName() + "-Accumulator:: s= " + s + ", p= " + p.getIncome()
					+ ", s+p= " + (s + p.getIncome()));
			return s + p.getIncome();
		}, (a, b) -> {
			System.out.println(
					Thread.currentThread().getName() + "-Combiner:: a= " + a + ", b= " + b + ", a+b= " + (a + b));
			return a + b;
		});
		System.out.println("4.Total Salary: " + totalSalary);
	}
}