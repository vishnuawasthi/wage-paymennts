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

	public static void checkStr(String str, String type, String name) {
		String report  = str.concat(getType(type)).concat(getName(name));
		System.out.println("report : "+report);
	}

	public static String getType(String type) {
		String str = null;
		if ("A".equalsIgnoreCase(type)) {
			str = "A";
		} else if ("B".equalsIgnoreCase(type)) {
			str = "B";
		} else {
			str = "All";
		}
		return str;
	}
	
	
	public static String getName(String name) {
		String str = null;
		if ("R".equalsIgnoreCase(name)) {
			str = "Ravi";
		} else if ("B".equalsIgnoreCase(name)) {
			str = "Bat";
		} else {
			str = "All";
		}
		return str;
	}
	

	/*public static void main(String args[]) {
		checkStr(null, "B","R");
		
		
	}*/

}
