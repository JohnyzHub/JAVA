package com.corejava.design.patterns.behavioral.command;

/**
 * @author johnybasha
 *
 */
public class BuyCommand implements Command {

	private Stock stock;

	public BuyCommand(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.buy();

	}

}
