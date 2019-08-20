package com.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtility {

	// ^[a-zA-Z0-9]*$
	public static boolean regExpCheck(Object value, String expression) {
		Pattern p = Pattern.compile(expression);// . represents single character
		Matcher m = p.matcher(String.valueOf(value));
		boolean result = m.matches();
		return result;

	}

	/*public static void main(String args[]) {
		String expression = "^[a-zA-Z0-9]*$";
		Object value = "jfkdjfjdklfjlfkjdlf7987897";
		boolean result = regExpCheck(value, expression);
		System.out.println("result : "+result);
	}*/
}
