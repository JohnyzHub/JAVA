package com.corejava.design.patterns.state;

/**
 * @author johnybasha
 *
 */
public class OnState extends RoboticState {

	private Robot robot;

	public OnState(Robot robot) {
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
		this.robot.setWalkState();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.state.RoboticState#cook()
	 */
	@Override
	public void cook() {
		System.out.println("Cooking...");
		this.robot.setCookState();
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
