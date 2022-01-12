package com.tss.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

public class Utility {

	/**
	 * This method checks weather the given email is valid or not.
	 * 
	 * @param email - emailId of the user
	 * @return boolean
	 * @author Siva Priya
	 * @since 2022-01-07
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
	 * This method checks whether the given mobile number is valid or not.
	 * 
	 * @param number - Mobile number of the user
	 * @return boolean
	 * @author Siva Priya
	 * @since 2022-01-07
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
	 * This method checks whether the given object is empty or not
	 * 
	 * @param obj - object take from user
	 * @return boolean
	 * @author Siva Priya
	 * @since 2022-01-07
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
		else if (obj instanceof File)
			return (true);
		return false;
	}

	/**
	 * This method runs the output
	 * 
	 * @param args - Print the output
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static void main(String[] args) {
		String name = " ";
		System.out.println(Utility.isBlank(name));
		System.out.print(name.isEmpty());

		int number = 2;
		System.out.println(Utility.isBlank(number));

		List<Integer> list = new ArrayList<>();
		System.out.println(Utility.isBlank(list));

	}

	/**
	 * This method generates the otp
	 * 
	 * @param length - length of the input
	 * @return Integer
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static int generateOtp(int length) {
		Random random = new Random();
		int otp = random.nextInt(length);
		return otp;
	}

	/**
	 * This method is used to upload a file.
	 * 
	 * @param filePart - file taking from the user
	 * @return boolean
	 * @throws IOException
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static boolean uploadFile(Part filePart) throws IOException {
		if (isBlank(filePart)) {
			return false;
		}
		String fileName = filePart.getSubmittedFileName();
		File file = new File("F:\\images\\" + File.separator + fileName);
		Files.copy(filePart.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return true;

	}

}
