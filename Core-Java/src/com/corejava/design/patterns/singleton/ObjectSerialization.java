package com.corejava.design.patterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author johnybasha
 *
 */
public class ObjectSerialization<T> {
	private String fileName = "objectFile.ser";

	public T getSerializedObject(T obj) {
		boolean isSerialized = serialize(obj);
		if (isSerialized) {
			return deserialize();
		}
		return null;
	}

	private boolean serialize(T obj) {
		boolean isSuccess = false;
		try (FileOutputStream fileOutStream = new FileOutputStream(fileName);
				ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream);) {
			objOutStream.writeObject(obj);
			isSuccess = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	@SuppressWarnings("unchecked")
	private T deserialize() {
		T result = null;
		try (FileInputStream fileInStream = new FileInputStream(fileName);
				ObjectInputStream objInStream = new ObjectInputStream(fileInStream)) {
			result = (T) objInStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
}