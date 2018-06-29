/**
 * 
 */
package com.corejava.design.patterns.structural.adapter;

/**
 * @author johnybasha
 *
 */
public class USElectricSocket {

	public void streamUSVolts(USPlugConnector plug) {
		System.out.println("US Volts: " + plug.getUSVolts());
	}

}
