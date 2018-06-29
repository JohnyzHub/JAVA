package com.corejava.design.patterns.creational.singleton;

/**
 * @author johnybasha
 *
 */
public final class SynchrInstance {

	private static volatile SynchrInstance instance;

	private SynchrInstance() {
		if (instance != null) {
			throw new RuntimeException("Already initialized");
		}

	}

	public static SynchrInstance getInstance() {
		SynchrInstance result = instance;
		if (result == null) {
			synchronized (SynchrInstance.class) {
				result = instance;
				if (result == null) {
					instance = result = new SynchrInstance();
				}
			}
		}
		return instance;
	}
}
