package com.corejava.design.patterns.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author johnybasha
 *
 */
public final class InnerStaticClass implements Serializable {

	private static final long serialVersionUID = 1l;

	private static class InstanceHolder {
		private static final InnerStaticClass _instance = new InnerStaticClass();
	}

	private InnerStaticClass() {
		if (InstanceHolder._instance != null) {
			throw new RuntimeException("Use InnerStaticClass.getInstance() instead.");
		}
	}

	public static InnerStaticClass getInstance() {
		return InstanceHolder._instance;
	}

	private Object readResolve() throws ObjectStreamException {
		return InstanceHolder._instance;
	}

	private Object writeReplace() throws ObjectStreamException {
		return InstanceHolder._instance;
	}
}
