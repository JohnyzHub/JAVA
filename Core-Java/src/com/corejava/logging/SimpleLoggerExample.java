/**
 * 
 */
package com.corejava.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author johnybasha
 *
 */
public class SimpleLoggerExample {

	public static void main(String[] args) {
		Logger logger = getLogger();
		logger.info("Logger name: " + logger.getName());
		logger.warning("About to raise ArrayIndexOutofBoundsException");

		int[] numbers = { 1, 2, 3 };
		int index = 4;
		logger.config("Index is set to:" + index);
		logger.finest("This is finest message");
		try {
			System.out.println(numbers[index]);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception occured: " + e.getMessage(), e);
		}
	}

	public static Logger getLogger() {
		Logger logger = Logger.getLogger(SimpleLoggerExample.class.getSimpleName());

		Handler consoleHandler = new ConsoleHandler();
		Handler fileHandler = null;
		try {
			fileHandler = new FileHandler("resources/logFile.log");
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}

		Formatter formatter = new SimpleFormatter();
		consoleHandler.setFormatter(formatter);
		fileHandler.setFormatter(formatter);

		logger.addHandler(consoleHandler);
		logger.addHandler(fileHandler);

		logger.setLevel(Level.ALL);
		consoleHandler.setLevel(Level.ALL);
		fileHandler.setLevel(Level.ALL);

		return logger;
	}

}
