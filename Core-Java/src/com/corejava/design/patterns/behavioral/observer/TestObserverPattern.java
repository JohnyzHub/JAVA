package com.corejava.design.patterns.behavioral.observer;

import java.util.Arrays;

/**
 * @author johnybasha
 *
 */
public class TestObserverPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NewsAgency agency = new NewsAgency();
		FoxNews foxNews = new FoxNews();
		AbcNews abcNews = new AbcNews();

		agency.addPropertyChangeListeners(Arrays.asList(foxNews, abcNews));

		agency.setWeatherNews("Todays forcast is cold.");
		foxNews.dispalyNews();
		abcNews.dispalyNews();

		agency.removePropertyChangeListener(abcNews);
		agency.setWeatherNews("Todays forcast is warm.");
		agency.setPoliticalNews("A big deal is signed by USA");
		foxNews.dispalyNews();
		abcNews.dispalyNews();
	}
}