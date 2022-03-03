package com.tss.test;

import java.sql.Connection;

import com.tss.util.DbUtil;
import com.tss.util.FileUtils;

public class AddingDataFromFile {
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "The@1234";
	public static final String SCHEMA = "practice";
	public static final int PORT = 3306;

	public static void main(String[] args) throws Exception {
		Connection connection = DbUtil.getConnection("localhost", PORT, SCHEMA, USER_NAME, PASSWORD);
		DbUtil.batchUpdate(connection, "INSERT INTO app_menu(lang, name, description)" + "VALUES(?, ?, ?)", FileUtils.readFileData("F:\\txt1\\app_menu.csv"));
		DbUtil.closeConnection(connection);
	}

}
