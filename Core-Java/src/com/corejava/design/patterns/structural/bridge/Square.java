/**
 * 
 */
package com.corejava.design.patterns.structural.bridge;

/**
 * @author johnybasha
 *
 */
public class Square extends AbstractShape {

	public Square(Color colr) {
		super(colr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.bridge.AbstractShape#draw()
	 */
	@Override
	public void draw() {
		System.out.print("\nDrawing Square...");
		this.color.applyColor();
	}
}