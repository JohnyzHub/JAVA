package com.corejava.reflection;

/**
 * @author johnybasha
 *
 */
public class TechBook extends Book {

	private int pages;

	public TechBook() {
		super();
		this.pages = 100;
	}

	public TechBook(String name, BookType type, int pages) {
		super(name, type);
		this.pages = pages;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "TechBook [name=" + getName() + ", type=" + getType() + ", pages=" + getPages() + "]";
	}

}
