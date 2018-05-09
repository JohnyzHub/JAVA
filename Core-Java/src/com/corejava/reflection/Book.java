package com.corejava.reflection;

/**
 * @author johnybasha
 *
 */
public class Book {

	private String name;

	private BookType type;

	public Book() {
		name = "Core Java";
		type = BookType.PAPERBACK;
	}

	public Book(String name, BookType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", type=" + type + "]";
	}
}