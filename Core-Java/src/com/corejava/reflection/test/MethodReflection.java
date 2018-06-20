package com.corejava.reflection.test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.corejava.reflection.Employee;
import com.corejava.reflection.test.util.ExecutableUtil;

/**
 * @author johnybasha
 *
 */
public class MethodReflection {

	public static void main(String[] args) {
		MethodReflection reflection = new MethodReflection();
		Class<Employee> c = Employee.class;

		reflection.getMethodsList(c);

		// reflection.getDeclaredMethodsList(c);
	}

	public void getDeclaredMethodsList(Class<Employee> c) {
		Method[] methods = c.getDeclaredMethods();
		List<String> methodsDescriptionList = getMethodDescription(methods);
		System.out.println("\nEmployee.class Declared Methods: ");
		methodsDescriptionList.forEach(System.out::println);
	}

	public void getMethodsList(Class<Employee> c) {
		Method[] methods = c.getMethods();
		List<String> methodsDescriptionList = getMethodDescription(methods);
		System.out.println("Employee.class Methods: ");
		methodsDescriptionList.forEach(System.out::println);
	}

	public List<String> getMethodDescription(Method[] methods) {

		List<String> methodList = new ArrayList<String>(methods.length);

		for (Method method : methods) {
			String annotations = ExecutableUtil.getAnnotations(method);
			String modifiers = ExecutableUtil.getModifiers(method);
			String returnType = method.getReturnType().getSimpleName();
			String name = method.getName();
			String paramList = ExecutableUtil.getParameters(method);
			String exceptions = ExecutableUtil.getThrowsClause(method);
			methodList.add(annotations + " " + modifiers + " " + returnType + " " + name + paramList + exceptions);

		}
		return methodList;
	}
}