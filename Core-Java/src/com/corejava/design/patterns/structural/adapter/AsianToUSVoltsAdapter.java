/**
 * 
 */
package com.corejava.design.patterns.structural.adapter;

/**
 * @author johnybasha
 *
 */
public class AsianToUSVoltsAdapter implements USPlugConnector {

	private AsianPlugConnector plug;

	public AsianToUSVoltsAdapter(AsianPlugConnector plug) {
		this.plug = plug;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.corejava.design.patterns.adapter.USPlugConnector#getUSVolts()
	 */
	@Override
	public int getUSVolts() {
		int asianVolts = this.plug.getAsianVolts();
		System.out.println("\nusing adapter: Converting " + asianVolts + " volts from Asian to US ....");
		return asianVolts / 2;
	}

}
