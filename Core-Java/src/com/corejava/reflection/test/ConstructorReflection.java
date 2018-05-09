package com.corejava.reflection.test;

import java.lang.reflect.Constructor;

import com.corejava.reflection.Employee;
import com.corejava.reflection.test.util.ExecutableUtil;

/**
 * @author johnybasha
 *
 */
public class ConstructorReflection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConstructorReflection reflection = new ConstructorReflection();
		Class<Employee> employee = Employee.class;
		Constructor<?>[] constructors = employee.getConstructors();
		System.out.println("Employee.class Constructors::");
		reflection.constructorDescription(constructors);

		constructors = employee.getDeclaredConstructors();
		System.out.println("\nEmployee.class Declared Constructors::");
		reflection.constructorDescription(constructors);
	}

	public void constructorDescription(Constructor<?>[] constructors) {
		for (Constructor<?> c : constructors) {
			String modifiers = ExecutableUtil.getModifiers(c);
			String name = c.getName();
			String params = ExecutableUtil.getParameters(c);
			String exceptions = ExecutableUtil.getThrowsClause(c);
			System.out.println(modifiers + " " + name + params + exceptions);
		}
	}
}