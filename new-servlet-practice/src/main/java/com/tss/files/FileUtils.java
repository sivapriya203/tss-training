package com.tss.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.tss.util.Utility;

public class FileUtils {

	public static void main(String[] args) throws Exception {
//		System.out.println(createFile());
//		System.out.println(readData(new File("F:\\txt1\\text1.csv")));
//		System.out.println(writeData(new File("F:\\txt1\\text2.txt"),"Heyy"));
//		System.out.println(getFile("F:\\txt1\\temp.csv"));
//		System.out.println(readFile(new File("F:\\txt1\\text1.csv")));
//		System.out.println(writeToFile(new File("F:\\txt1\\text2.txt"),"Heyy"));
//		System.out.println(FileUtils.replaceLineInTextFile(new File("F:\\txt1\\text1.csv"), "This is examplee", 4));
		String newLine = "Java";
		int lineToBeEdited = 3;
		File file = new File("F:\\txt1\\RoomType.csv");
		System.out.println(modifyData(file, lineToBeEdited, newLine));
	}

	/**
	 * This method is used to create a file
	 * 
	 * @return String
	 */
	public static String createFile() {
		try {
			File myObj = new File("F:\\txt1\\text2.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created:" + myObj.getName());
			} else {
				return "File exists already";
			}
		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		return "created";
	}

	/**
	 * This method is used to read the data in a List Array
	 * 
	 * @param fileName
	 * @return String
	 * @throws IOException
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static String readData(File fileName) throws IOException {
		if (Utility.isBlank(fileName) && fileName.equals("")) {
			return null;
		}
		BufferedReader bufReader = new BufferedReader(new FileReader(fileName));
		List<String> list = new ArrayList<>();
		String line = bufReader.readLine();
		while (line != null) {
			list.add(line);
			line = bufReader.readLine();
		}
		bufReader.close();
		return list.toString();
	}

	/**
	 * This method is used to write data in a file
	 * 
	 * @param file
	 * @param str
	 * @author Siva Priya
	 * @since 2022-02-16
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean writeData(File file, String str) throws IOException {
		if (Utility.isBlank(file) || Utility.isBlank(str) || !(file.exists())) {
			return false;
		}
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileWriter.close();
		}
		return true;
	}

	/**
	 * This method is used to check path is valid or not and exists or not, and in
	 * case path is not exists then create new file
	 * 
	 * @author Siva Priya
	 * @since 2022-02-16
	 * @return File
	 * @param path
	 * @throws Exception
	 */
	public static File getFile(String path) throws Exception {
		if (Utility.isBlank(path)) {
			return null;
		}
		File file = null;
		try {
			file = new File(path);
			if (file.createNewFile()) {
				return file;
			}
			if (file.isDirectory()) {
				throw new FileSystemException("It is a Directory");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * This method is used to replace line data using line number
	 * 
	 * @param file
	 * @param line
	 * @param lineNumber
	 * @author Siva Priya
	 * @since 2022-02-16
	 * @return boolean
	 * @throws IOException
	 */
	public static boolean replaceLineInTextFile(File file, String line, int lineNumber) throws IOException {
		if (Utility.isBlank(file) || Utility.isBlank(line) || Utility.isBlank(lineNumber)) {
			return false;
		}
		try {
			String content = new String();
			String editedContent = new String();
			content = readFile(file);
			editedContent = editLineInContent(content, line, lineNumber);
			writeData(file, editedContent);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * This method is used to check number of lines in a file
	 * 
	 * @author Siva Priya
	 * @since 2022-02-17
	 * @param content
	 * @return int
	 */
	private static int numberOfLinesInFile(String content) {
		int numberOfLines = 0;
		int index = 0;
		int lastIndex = 0;
		lastIndex = content.length() - 1;
		while (true) {
			if (content.charAt(index) == '\n') {
				numberOfLines++;
			}
			if (index == lastIndex) {
				numberOfLines = numberOfLines + 1;
				break;
			}
			index++;
		}
		return numberOfLines;
	}

	/**
	 * This method is used to convert the File into Array of Strings
	 * 
	 * @author Siva Priya
	 * @since 2022-02-17
	 * @param content
	 * @param lines
	 * @return String[]
	 */
	private static String[] turnFileIntoArrayOfStrings(String content, int lines) {
		String[] array = new String[lines];
		int index = 0;
		int tempInt = 0;
		int startIndext = 0;
		int lastIndex = content.length() - 1;
		while (true) {
			if (content.charAt(index) == '\n') {
				tempInt++;
				String tempOne = new String();
				for (int i = 0; i < index - startIndext; i++) {
					tempOne += content.charAt(startIndext + i);
				}
				startIndext = index;
				array[tempInt - 1] = tempOne;
			}
			if (index == lastIndex) {
				tempInt++;
				String tempOne = new String();
				for (int i = 0; i < index - startIndext + 1; i++) {
					tempOne += content.charAt(startIndext + i);
				}
				array[tempInt - 1] = tempOne;
				break;
			}
			index++;
		}
		return array;
	}

	/**
	 * This method is used to edit the line in the file
	 * 
	 * @author Siva Priya
	 * @since 2022-02-17
	 * @param content
	 * @param newLine
	 * @param line
	 * @return String
	 */
	private static String editLineInContent(String content, String newLine, int line) {
		int lineNumber = 0;
		lineNumber = numberOfLinesInFile(content);
		String[] lines = new String[lineNumber];
		lines = turnFileIntoArrayOfStrings(content, lineNumber);
		if (line != 1) {
			lines[line - 1] = "\n" + newLine;
		} else {
			lines[line - 1] = newLine;
		}
		content = new String();
		for (int i = 0; i < lineNumber; i++) {
			content += lines[i];
		}
		return content;
	}

	/**
	 * This method is used to read the content from the file
	 * 
	 * @author Siva Priya
	 * @since 2022-02-17
	 * @param filename
	 * @return String
	 */
	private static String readFile(File filename) {
		String content = null;
		FileReader reader = null;
		try {
			reader = new FileReader(filename);
			char[] chars = new char[(int) filename.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return content;
	}

	/**
	 * This method is used to replace line from one temporary file to original file
	 * 
	 * @param originalFile
	 * @param lineNumber
	 * @param line
	 * @return boolean
	 * @throws Exception
	 */
	public static boolean modifyData(File originalFile, int lineNumber, String line) throws Exception {
		File tempFile = FileUtils.getFile("F:\\txt1\\tempFile.csv");
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(originalFile));
			writer = new BufferedWriter(new FileWriter(tempFile));
			int count = 0;
			boolean status = false;
			String lineFromFile = "";
			while ((lineFromFile = reader.readLine()) != null) {
				count++;
				if (count == lineNumber) {
					writer.write(line + "\n");
					status = true;
				} else {
					writer.write(lineFromFile + "\n");
				}
				writer.flush();
			}
			if(status) {
				originalFile.delete();
				Files.move(tempFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
			tempFile.deleteOnExit();
		}
		return true;
	}

}
