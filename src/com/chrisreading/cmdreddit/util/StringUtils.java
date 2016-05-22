package com.chrisreading.cmdreddit.util;

/**
 * Padright, padleft
 */
public class StringUtils {
	
	/**
	 * Pads the string to the right
	 * @param str String to pad
	 * @param length how much to pad
	 * @return the formatted string
	 */
	public static String padRight(String str, int length) {
		return String.format("%1$-" + length + "s", str);
	}
	
	/**
	 * Pads the string to the left
	 * @param str String to pad
	 * @param length how much to pad
	 * @return the formatted string
	 */
	public static String padLeft(String str, int length) {
		return String.format("%1$" + length + "s", str);
	}

}
