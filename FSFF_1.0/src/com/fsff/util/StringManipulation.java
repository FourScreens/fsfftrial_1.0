package com.fsff.util;

public class StringManipulation {

	/**
	 * 
	 * @param toCheck
	 * @return
	 */
	public static boolean isNullOrEmpty(String toCheck) {
		if (toCheck == null || toCheck.isEmpty()) {
			return true;
		}
		return false;
	}
}
