/**
 * 
 */
package com.corejava.design.patterns.state;

/**
 * @author johnybasha
 *
 */
public class Robot implements RoboticState {

	private RoboticState state;

	public Robot() {
		this.state = new OnState(this);
		this.state.on();
	}

	public RoboticState getState() {
		return state;
	}

	public void setState(RoboticState state) {
		this.state = state;
	}

	public void setOnState() {
		this.state = new OnState(this);
	}

	public void setWalkState() {
		this.state = new WalkState(this);
	}

	public void setCookState() {
		this.state = new CookState(this);
	}

	public void setOffState() {
		this.state = new OffState(this);
	}

	@Override
	public void on() {
		this.state.on();

	}

	@Override
	public void walk() {
		this.state.walk();

	}

	@Override
	public void cook() {
		this.state.cook();

	}

	@Override
	public void off() {
		this.state.off();

	}

}
