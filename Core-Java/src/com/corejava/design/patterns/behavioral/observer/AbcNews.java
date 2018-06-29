package com.corejava.design.patterns.behavioral.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author johnybasha
 *
 */
public class AbcNews implements PropertyChangeListener {

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
		if (propertyName != null && propertyName.equalsIgnoreCase("weather")) {
			this.news = (String) evt.getNewValue();
		}
	}

	public void dispalyNews() {
		System.out.println("Weather:: " + this.news);
	}
	
	@Override
	public String toString() {
		return "AbcNews";
	}
}
