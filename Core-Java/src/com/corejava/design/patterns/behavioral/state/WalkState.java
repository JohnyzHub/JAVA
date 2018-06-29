package com.corejava.design.patterns.behavioral.state;

/**
 * @author johnybasha
 *
 */
public class WalkState extends RoboticState {

	private Robot robot;

	public WalkState(Robot robot) {
		this.robot = robot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#on()
	 */
	@Override
	public void on() {
		System.out.println("Turned on...");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#walk()
	 */
	@Override
	public void walk() {
		System.out.println("Walking...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#cook()
	 */
	@Override
	public void cook() {
		System.out.println("Cooking..");
		this.robot.setCookState();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#off()
	 */
	@Override
	public void off() {
		System.out.println("Switching off..");
		this.robot.setOffState();
	}
}
