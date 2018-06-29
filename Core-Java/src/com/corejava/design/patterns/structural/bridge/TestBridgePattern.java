/**
 * 
 */
package com.corejava.design.patterns.structural.bridge;

/**
 * @author johnybasha
 *
 */
public class TestBridgePattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Color red = () -> System.out.print("coloring with red...");
		Color green = () -> System.out.print("coloring with green...");

		new Circle(red).draw();
		new Square(green).draw();

	}

}
