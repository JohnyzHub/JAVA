package com.corejava.design.patterns.behavioral.command;

/**
 * @author johnybasha
 *
 */
public class TestCommandPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Context
		Stock loosingStock = new Stock();
		Stock gainingStock = new Stock();

		// Command
		BuyCommand buyCommand = new BuyCommand(gainingStock);
		SellCommand sellCommand = new SellCommand(loosingStock);

		// Command Operator
		StocksBroker broker = new StocksBroker();
		broker.addCommand(sellCommand);
		broker.addCommand(buyCommand);

		// Command Operation
		broker.operate();

	}

}
