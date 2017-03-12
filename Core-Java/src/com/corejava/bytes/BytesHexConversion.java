package com.corejava.bytes;

import org.apache.commons.codec.binary.Hex;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;


public class BytesHexConversion {

	public static void main(String[] args) {
		byte[] bytes = new byte[]{'a', 'b', 0, 5, 'c', 'd'};
		byte[] nonPrintable = new byte[]{'a', 'b', 0, 6, 'c', 'd'};


		String nonPrintableToString = new String(nonPrintable);
		System.out.println("nonPrintable : " + nonPrintableToString);

		String bytesToString = new String(bytes);
		System.out.println("bytes : " + bytesToString);

		String hexString = bytesToHexString(bytes);
		System.out.println("bytes to HexString - With core java : " + hexString);

		byte[] receviedBytes = hexStringToByteArray(hexString);
		System.out.println("hexString to Bytes - with core java : " + receviedBytes);

		System.out.println(" Are bytes equal : " + String.valueOf(Arrays.equals(bytes, receviedBytes)));


		/**
		 * Using Apache Commons Codec Library
		 */

		// Converting bytes to Hex format.
		hexString = toHexUsingApache(bytes);
		System.out.println("bytes to HexString - Using Apache.commons.codec library : " + hexString);

		//Converting Hex String to original bytes format.
		receviedBytes = fromHexUsingApache(hexString);
		System.out.println("HexString to Bytes - Using Apache.commons.codec library : " + receviedBytes);

		//Checking whether the bytes before and after conversion equal.
		System.out.println(" Are bytes equal : " + String.valueOf(Arrays.equals(bytes, receviedBytes)));


		/**
		 * Using JAXB DatatypeConverter
		 */
		// Converting bytes to Hex format.
		hexString = toHexString(bytes);
		System.out.println("bytes to HexString - Using JAXB : " + hexString);

		//Converting Hex String to original bytes format.
		receviedBytes = toByteArray(hexString);
		System.out.println("HexString to Bytes - Using JAXB : " + receviedBytes);

		//Checking whether the bytes before and after conversion equal.
		System.out.println(" Are bytes equal : " + String.valueOf(Arrays.equals(bytes, receviedBytes)));

		//Notice that the byte array resulted on each run/ each library is different because it depends on the hashcode generation.

	}

	/**
	 *    *** Using regular java code*** 
	 * 
	 */


	public static String bytesToHexString(byte[] bytes) {
		StringBuilder sBuilder = new StringBuilder("");

		for (byte b : bytes) {
			sBuilder.append(String.format("%02x", b & 0xff));
		}
		return sBuilder.toString();
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i+1), 16));
		}
		return data;
	}


	/**
	 *    *** Using Apache Codec Library *** 
	 * 
	 */

	public static String toHexUsingApache(byte[] byteArray) {
		return Hex.encodeHexString(byteArray);
	}

	public static byte[] fromHexUsingApache(String hexString) {
		byte[] byteArray = null;
		try {
			byteArray = Hex.decodeHex(hexString.toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byteArray;
	}


	/**
	 *    *** Using JAXB Library *** 
	 * 
	 */    

	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}

	public static byte[] toByteArray(String s) {
		return DatatypeConverter.parseHexBinary(s);
	}	

}
