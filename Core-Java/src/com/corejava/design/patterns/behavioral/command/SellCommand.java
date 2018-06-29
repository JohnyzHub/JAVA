package com.corejava.design.patterns.behavioral.command;

/**
 * @author johnybasha
 *
 */
public class SellCommand implements Command {

	private Stock stock;

	public SellCommand(Stock stock) {
		this.stock = stock;
	}

	@Override
	public void execute() {
		stock.sell();

	}

}
