/**
 * 
 */
package com.corejava.design.patterns.structural.bridge;

/**
 * @author johnybasha
 *
 */
public class Circle extends AbstractShape {

	public Circle(Color colr) {
		super(colr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.bridge.AbstractShape#draw()
	 */
	@Override
	public void draw() {
		System.out.print("\nDrawing circle...");
		this.color.applyColor();
	}
}
