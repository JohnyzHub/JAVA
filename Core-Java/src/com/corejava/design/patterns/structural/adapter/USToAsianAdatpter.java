/**
 * 
 */
package com.corejava.design.patterns.structural.adapter;

/**
 * @author johnybasha
 *
 */
public class USToAsianAdatpter implements AsianPlugConnector {

	private USPlugConnector usPlug;

	public USToAsianAdatpter(USPlugConnector usPlug) {
		this.usPlug = usPlug;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.adapter.USPlugConnector#getUSVolts()
	 */
	@Override
	public int getAsianVolts() {
		int usVolts = this.usPlug.getUSVolts();
		System.out.println("\nusing adapter:Converting " + usVolts + " volts from US to Asian using adapter....");
		return usVolts * 2;
	}
}