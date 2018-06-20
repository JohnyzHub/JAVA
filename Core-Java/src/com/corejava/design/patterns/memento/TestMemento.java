package com.corejava.design.patterns.memento;

public class TestMemento {

	public static void main(String args[]) {

		TestMemento testMemento = new TestMemento();

		Item shampoo = new Item("Shampoo", 5);
		Item conditioner = new Item("Conditioner", 3.49);
		Item toothPaste = new Item("ToothPaste", 2.5);
		Item mouthWash = new Item("Mouthwash", 1.5);
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(shampoo);
		cart.addItem(conditioner);
		cart.saveItems();
		testMemento.printDetails(cart);
		cart.addItem(toothPaste);
		testMemento.printDetails(cart);
		cart.undo();
		testMemento.printDetails(cart);
		cart.addItem(mouthWash);
		cart.redo();
		cart.addItem(toothPaste);
		cart.undo();
		cart.saveItems();
		testMemento.printDetails(cart);

	}

	public void printDetails(ShoppingCart cart) {
		System.out.println("Cart size: " + cart.size());
		System.out.println(cart);
	}
}
