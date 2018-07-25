/**
 * 
 */
package com.corejava.logging.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author johnybasha
 *
 */
public class LoggerConfigExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = getLogger();
		logger.finest("This is finest message");

	}
	
	public static Logger getLogger() {
		Logger logger = Logger.getLogger("simpleLogger");
		
		LogManager logManager = LogManager.getLogManager();
		
		try {
			logManager.readConfiguration(new FileInputStream("logger.properties"));
		} catch(IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		
		
		return logger;
	}

}
