package com.corejava.reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.corejava.reflection.Book;
import com.corejava.reflection.BookType;
import com.corejava.reflection.TechBook;

/**
 * @author johnybasha
 *
 */
public class ObjectReflection {

	public static void main(String[] args) {
		ObjectReflection reflection = new ObjectReflection();
		reflection.performReflection();
	}

	public void performReflection() {
		Class<TechBook> book = TechBook.class;
		objectWithConstructor_NoArgs(book);
		objectWithConstructor_args(book);
		invokeMethodOnObject(book);
		checkSecurityManager();
		changeFieldValue(book);
	}

	public void objectWithConstructor_NoArgs(Class<TechBook> book) {
		try {
			Book bookObject = book.newInstance();
			System.out.println("Object creation using Constructor with no-args:: " + bookObject);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	public void objectWithConstructor_args(Class<TechBook> book) {
		try {
			Field bookName = getField(book, "name");
			Field bookType = getField(book, "type");
			Field pages = getField(book, "pages");

			Constructor<TechBook> constructor = book.getConstructor(bookName.getType(), bookType.getType(),
					pages.getType());
			Book bookObject = constructor.newInstance("Beginning Java", BookType.EPUB, 200);
			System.out.println("Object creation using Constructor with args:: " + bookObject);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	public void invokeMethodOnObject(Class<TechBook> book) {
		try {
			TechBook techBook = book.newInstance();
			Field pages = getField(book, "pages");
			Method setPages = book.getMethod("setPages", pages.getType());
			setPages.invoke(techBook, 150);
			System.out.println("Method invocation - TechBook.setPages() :: " + techBook);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void changeFieldValue(Class<TechBook> book) {
		System.out.println("\nAltering field value by reflection::");
		Field name = getField(book, "name");
		try {
			TechBook techBook = book.newInstance();
			String nameVal = (String) name.get(techBook);
			System.out.println("Name of the book: " + nameVal);
			name.set(techBook, "Java Fundamentals");
			nameVal = (String) name.get(techBook);
			System.out.println("New name of the book: " + nameVal);
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}

	public Field getField(Class<TechBook> bookClass, String fieldName) {
		Field field = null;
		try {
			field = bookClass.getDeclaredField(fieldName);
			field.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
			Class superClass = bookClass.getSuperclass();
			if (superClass == null) {
				e.printStackTrace();
			} else {
				field = getField(superClass, fieldName);
			}
		}

		return field;
	}

	public void checkSecurityManager() {
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.out.println(
					"\nSecurity Manager is not installed ,\n\t hence can access private fields using setAccessible(true)");
		}
	}
}