package com.corejava.design.patterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author johnybasha
 *
 */
public class StocksBroker {

	private List<Command> commands;

	public void addCommand(Command command) {
		if (commands == null || commands.isEmpty()) {
			commands = new ArrayList<Command>(1);
		}
		commands.add(command);
	}

	public void operate() {
		if (commands == null || commands.isEmpty()) {
			return;
		}
		commands.forEach(Command::execute);
	}

}
