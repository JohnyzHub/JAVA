package com.corejava.design.patterns.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShoppingCart {

	private Item item;

	private Stack<Item> shoppingItems;

	private CartMemento cartMemento;

	public ShoppingCart() {
		shoppingItems = new Stack<Item>();
		cartMemento = new CartMemento();
	}

	public void addItem(Item item) {
		this.shoppingItems.push(item);
		this.item = item;
		System.out.println("Added : " + item);
	}

	public void saveItems() {
		cartMemento.save(shoppingItems);
		shoppingItems.clear();
		System.out.println("Saved items of the cart");
	}

	public void undo() {
		if (this.shoppingItems != null) {
			item = this.shoppingItems.pop();
			System.out.println("Removed : " + item);
		}
	}

	public void redo() {
		if (item != null) {
			addItem(item);
		}
		item = null;
	}

	public int size() {
		return this.shoppingItems.size() + cartMemento.size();
	}

	@Override
	public String toString() {
		return "ShoppingCart{" + cartMemento + "}\n";
	}

	private static class CartMemento {

		private List<Item> savedItems;

		CartMemento() {
			savedItems = new ArrayList<Item>();
		}

		private void save(Stack<Item> savedItems) {
			this.savedItems.addAll(savedItems);
		}

		private int size() {
			return this.savedItems.size();
		}

		@Override
		public String toString() {
			return "\n" + savedItems.toString();
		}
	}
}