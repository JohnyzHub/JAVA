/**
 * 
 */
package com.corejava.design.patterns.structural.bridge;

/**
 * @author johnybasha
 *
 */
public abstract class AbstractShape implements Shape {

	protected Color color;

	public AbstractShape(Color color) {
		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.bridge.Shape#draw()
	 */
	@Override
	public abstract void draw();

}
