package com.tss.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Part;

import com.tss.pojo.Branch;
import com.tss.pojo.Student;
import com.tss.test.StudentMain;

public class Utility extends StudentMain {

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
		else if (obj instanceof File)
			return !(((File) obj).isFile());
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
		String fileName = filePart.getSubmittedFileName();
		File file = new File("F:\\images\\" + File.separator + fileName);
		Files.copy(filePart.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		return true;
	}

	/**
	 * This method is used to take a particular word or sentence
	 * 
	 * @param data
	 * @param start
	 * @param end
	 * @return String
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static String typeA(String data, String start, String end) {
		try {
			if (isBlank(data) || isBlank(start) || isBlank(end)) {
				return "";
			}
			if (data.indexOf(start) != -1) {
				int endStr = data.indexOf(end, data.indexOf(start) + start.length());
				if (endStr != -1) {
					return data.substring(data.indexOf(start) + start.length(), endStr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method is used to print string after label
	 * 
	 * @param data
	 * @param label
	 * @param position
	 * @return String
	 * @author Siva Priya
	 * @since 2022-01-07
	 */

	public static String typeB(String data, String label, String position) {
		try {
			if (isBlank(data) || isBlank(label)) {
				return "";
			}
			if (isBlank(position)) {
				position = "any";
			}
			String lines[] = data.split("\r\n");
			for (String line : lines) {
				if (position.equalsIgnoreCase("start") && line.startsWith(label)) {
					return line.substring(line.indexOf(label) + label.length());
				}
				if (position.equalsIgnoreCase("any") && line.contains(label)) {
					return line.substring(line.indexOf(label) + label.length());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method is used to print string in between label and end
	 * 
	 * @param data
	 * @param label
	 * @param position
	 * @param start
	 * @param end
	 * @return String
	 * @author Siva Priya
	 * @since 2022-01-07
	 */

	public static String typeC(String data, String label, String position, String start, String end) {
		try {
			if (isBlank(data) || isBlank(label) || isBlank(start) || isBlank(end)) {
				return "";
			}
			if (isBlank(position)) {
				position = "any";
			}
			String lines[] = data.split("\r\n");
			for (String line : lines) {
				if (position.equalsIgnoreCase("any") && line.indexOf(label) > line.indexOf(start)
						&& line.indexOf(label) < line.indexOf(end)) {
					return line.substring(line.indexOf(label) + label.length(), line.indexOf(end)).trim();
				}
				if (position.equalsIgnoreCase("start") && line.contains(label) && line.contains(start)
						&& line.contains(end) && line.startsWith(start) && line.endsWith(end)) {
					return line.substring(line.indexOf(label) + label.length(), line.indexOf(end)).trim();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method is used to print String to camelCase
	 * 
	 * @param text
	 * @return String
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static String camelCase(String text) {
		if (isBlank(text)) {
			return "";
		}
		StringBuilder str = new StringBuilder();
		Boolean nextCapital = false;
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLetter(text.charAt(i))) {
				char temp = text.charAt(i);
				if (nextCapital)
					temp = Character.toUpperCase(temp);
				str.append(temp);
				nextCapital = false;
			} else {
				nextCapital = true;
			}
		}
		return str.toString();
	}

	/**
	 * This method is used to print String to pascalCase
	 * 
	 * @param text
	 * @return String
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static String pascalCase(String text) {
		if (isBlank(text)) {
			return "";
		}
		text = text.substring(0, 1).toUpperCase() + text.substring(1);
		StringBuilder builder = new StringBuilder(text);
		for (int i = 0; i < builder.length(); i++) {
			if (builder.charAt(i) == ' ') {
				builder.deleteCharAt(i);
				builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
			}
		}
		return builder.toString();
	}

	/**
	 * This method is used to print String to titlelCase
	 * 
	 * @param text
	 * @return String
	 * @author Siva Priya
	 * @since 2022-01-07
	 */
	public static String titleCase(String text) {
		if (isBlank(text)) {
			return "";
		}
		StringBuilder converted = new StringBuilder();
		boolean convertNext = true;
		for (char ch : text.toCharArray()) {
			if (Character.isSpaceChar(ch)) {
				convertNext = true;
			} else if (convertNext) {
				ch = Character.toTitleCase(ch);
				convertNext = false;
			} else {
				ch = Character.toLowerCase(ch);
			}
			converted.append(ch);
		}
		return converted.toString();
	}

	/**
	 * 
	 * @param length
	 * @return String
	 * @author Siva Priya
	 * @since 2022-03-02
	 */
	public static String generateAlphanumeric(int length) {
		if (Utility.isBlank(length) || length < 4 || length > 12) {
			return null;
		}
		int i = 0;
		String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder str = new StringBuilder();
		SecureRandom random = new SecureRandom();
		while (i < length) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			str.append(randomChar);
			i++;
		}
		return str.toString();
		// return generateAlphanumeric(length,1).get(0);
	}

	/**
	 * 
	 * @param length
	 * @param count
	 * @return String
	 * @author Siva Priya
	 * @since 2022-03-02
	 */
	public static ArrayList<String> generateAlphanumeric(int length, int count) {
		ArrayList<String> value = new ArrayList<String>();
		if (Utility.isBlank(count)) {
			return null;
		}
		for (int j = 0; j < count; j++) {
			value.add(generateAlphanumeric(length));
		}
		return value;
	}

	/**
	 * This method is used to remove extra spaces from given sentence
	 * 
	 * @author Siva Priya
	 * @since 2022-02-21
	 * @param myText
	 * @return String
	 */
	public static String removeExtraSpcaes(String text) {
		if (Utility.isBlank(text)) {
			return null;
		}
		return text.replaceAll("( )+", " ");
	}

	/**
	 * This method is used to remove all special characters and extra spaces from
	 * the sentence
	 * 
	 * @author Siva Priya
	 * @since 2022-02-21
	 * @param myText
	 * @return String
	 */
	public static String removeSpecialCharacters(String text) {
		if (Utility.isBlank(text)) {
			return null;
		}
		return text.replaceAll("[^a-zA-Z0-9]+()+", " ");
	}

	/**
	 * This method is used to print given number of zeros
	 * 
	 * @author Siva Priya
	 * @since 2022-02-21
	 * @param count
	 * @return String
	 */
	public static String generateZeros(int count) {
		if (Utility.isBlank(count)) {
			return null;
		}
		return String.format("%0" + count + "d", 0);
	}

	/**
	 * This method is used to find out the particular id from the youtube url and
	 * coverted into given format
	 * 
	 * @author Siva Priya
	 * @since 2022-02-22
	 * @param videoUrl
	 * @return String
	 */
	public static String extractEmbeddedId(String url) {
		if (Utility.isBlank(url)) {
			return null;
		}
		String format = "https://www.youtube.com/embed/";
		String videoId = "";
		String regex = "http(?:s)?:\\/\\/(?:m.)?(?:www\\.)?youtu(?:\\.be\\/|be\\.com\\/(?:watch\\?(?:feature=youtu.be\\&)?v=|v\\/|embed\\/|user\\/(?:[\\w#]+\\/)+))([^&#?\\n]+)";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			videoId = matcher.group(1);
		}
		return format.concat(videoId);
	}

	/**
	 * This method is used to check given ip address is valid or not
	 * 
	 * @author Siva Priya
	 * @since 2022-02-22
	 * @param ip
	 * @return boolean
	 */
	public static boolean isValidIpAddress(String ip) {
		if (Utility.isBlank(ip)) {
			return false;
		}
		String ipV4 = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])";
		String ipV6 = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
		Pattern ipv4Pattern = Pattern.compile(ipV4, Pattern.CASE_INSENSITIVE);
		Pattern ipv6Pattern = Pattern.compile(ipV6, Pattern.CASE_INSENSITIVE);
		Matcher match = ipv4Pattern.matcher(ip);
		Matcher matcher = ipv6Pattern.matcher(ip);
		if (match.matches() || matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used to sorted the array into list based on age
	 * 
	 * @author Siva Priya
	 * @since 2022-02-23
	 * @param student
	 * @return
	 * @throws IOException
	 */
	public static List<Student> sortByAge(List<Student> students) {
		Collections.sort(students);
		return students;
	}

	/**
	 * @This method is used to sort the students based on age in particular branch
	 * 
	 * @author Siva Priya
	 * @since 2022-02-24
	 * @param cse
	 * @return List
	 */
	public static List<Branch> sortingStudentAge(List<Branch> branches) {
		for (Branch branch : branches) {
			if (branch.getStudents() != null) {
				Collections.sort(branch.getStudents());
			}
		}
		return branches;
	}

	/**
	 * This method is used to display matching hobby list
	 * 
	 * @author Siva Priya
	 * @since 2022-02-24
	 * @param hobbyName
	 * @param branches
	 * @return List
	 */
	public static List<Student> getStudentsByHobby(String hobby, List<Branch> branches) {
		List<Student> students = new ArrayList<Student>();
		for (Branch branch : branches) {
			for (Student student : branch.getStudents()) {
				if (student.getHobbies().contains(hobby)) {
					students.add(student);
				}
			}
		}
		return students;

	}

}
