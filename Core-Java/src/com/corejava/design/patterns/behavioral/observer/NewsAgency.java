package com.corejava.design.patterns.behavioral.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * @author johnybasha
 *
 */
public class NewsAgency {

	private String weatherNews;
	private String politicalNews;

	private PropertyChangeSupport propertySupport;

	public NewsAgency() {
		propertySupport = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListeners(List<PropertyChangeListener> listeners) {
		if (listeners == null || listeners.isEmpty()) {
			return;
		}
		listeners.stream().forEach(a -> addPropertyChangeListener(a));
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (listener != null) {
			propertySupport.addPropertyChangeListener(listener);
			System.out.println("Added:"+listener);
		}
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (listener != null) {
			propertySupport.removePropertyChangeListener(listener);
			System.out.println("Removed:"+listener);
		}
	}

	public void setWeatherNews(String news) {
		propertySupport.firePropertyChange("weather", this.weatherNews, news);
		this.weatherNews = news;
	}

	public void setPoliticalNews(String news) {
		propertySupport.firePropertyChange("politics", this.politicalNews, news);
		this.politicalNews = politicalNews;
	}
}