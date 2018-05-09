package com.corejava.reflection.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.corejava.reflection.Employee;

public class FieldReflection {

	public static void main(String[] args) {
		FieldReflection methodRef = new FieldReflection();
		Class<Employee> empClass = Employee.class;
		System.out.println("\nField Description:: ");
		methodRef.getFieldDescription(empClass, "gender");

		List<String> fieldsList = methodRef.getFields(empClass);
		System.out.println("\nFields Description::\n");
		fieldsList.forEach(System.out::println);

		fieldsList = methodRef.getDeclaredFields(empClass);
		System.out.println("\nDeclared Fields Description::\n");
		fieldsList.forEach(System.out::println);
	}

	public List<String> getFields(Class<Employee> empClass) {
		Field[] fields = empClass.getFields();
		return getFieldsDescription(fields);
	}

	public List<String> getDeclaredFields(Class<Employee> empClass) {
		Field[] fields = empClass.getDeclaredFields();
		return getFieldsDescription(fields);
	}

	public void getFieldDescription(Class<Employee> empClass, String fieldName) {
		String fieldDescription = null;
		try {
			Field field = empClass.getDeclaredField(fieldName);
			fieldDescription = getFieldDescription(field);
		} catch (NoSuchFieldException e) {
			Class superClass = empClass.getSuperclass();
			if (superClass == null) {
				e.getStackTrace();
			} else {
				this.getFieldDescription(superClass, fieldName);
			}
		}
		if (fieldDescription == null) {
			return;
		}
		System.out.println(fieldDescription);
	}

	public List<String> getFieldsDescription(Field[] fields) {
		int fieldsSize = fields.length;
		List<String> fieldsList = new ArrayList<String>(fieldsSize);

		for (Field field : fields) {
			String fieldDescription = getFieldDescription(field);

			fieldsList.add(fieldDescription);
		}
		return fieldsList;
	}

	public String getFieldDescription(Field field) {
		field.setAccessible(true);
		int modifier = field.getModifiers() & Modifier.fieldModifiers();
		String modifiers = Modifier.toString(modifier);

		String fieldType = field.getType().getSimpleName();
		String fieldName = field.getName();

		String fieldDescription = modifiers + " " + fieldType + " " + fieldName;
		return fieldDescription;
	}
}