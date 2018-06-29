package com.corejava.design.patterns.behavioral.state;

/**
 * @author johnybasha
 *
 */
public abstract class RoboticState {

	protected abstract void on();

	protected abstract void walk();

	protected abstract void cook();

	protected abstract void off();

}
