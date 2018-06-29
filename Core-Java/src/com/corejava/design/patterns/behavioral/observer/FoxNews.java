package com.corejava.design.patterns.behavioral.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author johnybasha
 *
 */
public class FoxNews implements PropertyChangeListener {

	private String news;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		if (propertyName != null && propertyName.equalsIgnoreCase("politics")) {
			this.news = (String) evt.getNewValue();
		}
	}

	public void dispalyNews() {
		System.out.println("Politics:: " + this.news);
	}

	@Override
	public String toString() {
		return "FoxNews";
	}
	
	
}
