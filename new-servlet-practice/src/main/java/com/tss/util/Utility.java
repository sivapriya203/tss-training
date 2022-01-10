package com.tss.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class Utility {
	/**
	 * 
	 * @param email - emailId of the user
	 * @return - Check the emailId correct or not
	 */
	public static boolean validateEmail(String email) {
		if (isBlank(email)) {
			return false;
		}
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-xA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	/**
	 * 
	 * @param number - Mobile number of the user
	 * @return - Check the mobile number correct or not
	 */
	public static boolean isValidMobileNo(String number) {
		if (isBlank(number)) {
			return false;
		}
		Pattern pattern = Pattern.compile("(0/91)?[6-9][0-9]{9}");
		java.util.regex.Matcher match = pattern.matcher(number);
		return (match.find() && match.group().equals(number));
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isBlank(Object obj) {
		if (obj == null)
			return true;
		else if (obj instanceof String)
			return ((String) obj).trim().equals("");
		else if (obj instanceof Collection)
			return ((Collection<?>) obj).isEmpty();
		else if (obj instanceof Map)
			return ((Map<?, ?>) obj).isEmpty();
		else if (obj.getClass().isArray())
			return Array.getLength(obj) == 0;
		else if (obj instanceof Integer)
			return ((Integer) (obj) <= 0);
		else if (obj instanceof Float)
			return ((Float) (obj) <= 0);
		else if (obj instanceof Double)
			return ((Double) (obj) <= 0);
		else if (obj instanceof Long)
			return ((Long) (obj) <= 0);
		else if (obj instanceof Short)
			return ((Short) (obj) <= 0);
		else if (obj instanceof Byte)
			return ((Byte) (obj) <= 0);
		return false;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "Sivapriya";
		System.out.println(Utility.isBlank(name));

		int number = 2;
		System.out.println(Utility.isBlank(number));

		List<Integer> list = new ArrayList<>();
		System.out.println(Utility.isBlank(list));

	}

	/**
	 * 
	 * @param length
	 * @return
	 */
	public static char[] otpGeneration(int length) {
		String numbers = "0123456789";
		Random rndm = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = numbers.charAt(rndm.nextInt(numbers.length()));
		}
		return otp;
	}
}