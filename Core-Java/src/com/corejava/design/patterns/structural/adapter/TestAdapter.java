package com.corejava.design.patterns.structural.adapter;

/**
 * @author johnybasha
 *
 */
public class TestAdapter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		USPlugConnector usPlug = () -> {
			return 120;
		};
		USElectricSocket usSocket = new USElectricSocket();
		usSocket.streamUSVolts(usPlug);

		AsianPlugConnector asianPlug = () -> {
			return 240;
		};
		AsianElectricSocket asianSocket = new AsianElectricSocket();
		asianSocket.streamAsianVolts(asianPlug);

		AsianToUSVoltsAdapter usAdapter = new AsianToUSVoltsAdapter(asianPlug);
		usSocket.streamUSVolts(usAdapter);

		USToAsianAdatpter asianAdapter = new USToAsianAdatpter(usPlug);
		asianSocket.streamAsianVolts(asianAdapter);
	}

}
