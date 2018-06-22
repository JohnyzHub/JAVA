/**
 * 
 */
package com.corejava.design.patterns.state;

/**
 * @author johnybasha
 *
 */
public class Robot {

	private RoboticState state;

	public Robot() {
		this.state = new OnState(this);
		this.state.on();
	}

	protected RoboticState getState() {
		return state;
	}

	protected void setState(RoboticState state) {
		this.state = state;
	}

	protected void setOnState() {
		this.state = new OnState(this);
	}

	protected void setWalkState() {
		this.state = new WalkState(this);
	}

	protected void setCookState() {
		this.state = new CookState(this);
	}

	protected void setOffState() {
		this.state = new OffState(this);
	}

	public void on() {
		this.state.on();

	}

	public void walk() {
		this.state.walk();

	}

	public void cook() {
		this.state.cook();

	}

	public void off() {
		this.state.off();

	}

}
