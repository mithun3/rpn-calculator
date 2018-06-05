package org.rpn.util;

/**
 * This is a lookup util that will be used to return the required country.
 * @author 617150
 * 
 */
public class LookupUtil {
	/**
	 * A lookup utility to get a value from the Enum class.
	 * @param enumm	Instance of type Enum can be passed here.
	 * @param id	The type of id that need to be fetched can be passed form here.
	 * @return		The return type / result is the value of tye Enum.
	 */
	public static <E extends Enum<E>> E lookup(Class<E> enumm, String id) {
		E result = null;
		try {
			result = Enum.valueOf(enumm, id);
		} catch (IllegalArgumentException ex) {
			result = Enum.valueOf(enumm, "INVALID");
		}
		return result;
	}
	
}
