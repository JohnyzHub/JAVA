package com.corejava.reflection.test;

import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.corejava.reflection.Employee;

/**
 * @author johnybasha
 *
 */
public class ClassReflection {

	public ClassReflection() {
	}

	public static void main(String[] args) {
		ClassReflection reflection = new ClassReflection();
		Class<Employee> employee = Employee.class;
		System.out.println("Generic Class: " + employee.toGenericString());

		String classDesc = reflection.getClassDescription(employee);
		System.out.println("class: " + classDesc);

	}

	public String getClassDescription(Class<Employee> employee) {
		int modifierBits = employee.getModifiers() & Modifier.classModifiers();

		String modifiers = Modifier.toString(modifierBits);

		StringBuilder classDesc = new StringBuilder();
		classDesc.append(modifiers);
		classDesc.append(" class ");
		classDesc.append(employee.getSimpleName());

		String typeParams = getTypeParameters(employee);
		classDesc.append(typeParams);

		classDesc.append(" extends " + employee.getSuperclass().getSimpleName());

		String interfaces = getClassInterfaces(employee);
		classDesc.append(interfaces);

		return classDesc.toString();
	}

	public String getClassInterfaces(Class employee) {
		Class[] interfaces = employee.getInterfaces();
		int size = interfaces.length;
		if (interfaces.length <= 0) {
			return null;
		}

		List<String> interfaceList = new ArrayList<String>(size);

		for (int index = 0; index < size; index++) {
			interfaceList.add(interfaces[index].getSimpleName());
		}

		String interfaceNames = interfaceList.stream().collect(Collectors.joining(", ", " implements ", " "));
		return interfaceNames;

	}

	public String getTypeParameters(Class employee) {
		TypeVariable<?>[] params = employee.getTypeParameters();

		if (params.length <= 0) {
			return null;
		}

		int size = params.length;
		List<String> stringParams = new ArrayList<String>(size);
		for (int index = 0; index < size; index++) {
			stringParams.add(params[index].getTypeName());
		}

		String typeParams = stringParams.stream().collect(Collectors.joining(", ", "<", ">"));
		return typeParams;
	}
}