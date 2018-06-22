package com.corejava.design.patterns.state;

/**
 * @author johnybasha
 *
 */
public class CookState extends RoboticState {

	private Robot robot;

	public CookState(Robot robot) {
		this.robot = robot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#on()
	 */
	@Override
	public void on() {
		System.out.println("Robot is already on...");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#walk()
	 */
	@Override
	public void walk() {
		System.out.println("Can't walk while cooking...");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#cook()
	 */
	@Override
	public void cook() {
		System.out.println("Cooking...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#off()
	 */
	@Override
	public void off() {
		System.out.println("Switching off...");
		this.robot.setOffState();
	}

}
