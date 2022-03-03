package com.tss.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tss.util.DbUtil;

public class CrudOperations {
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "The@1234";
	public static final String SCHEMA = "practice";
	public static final int PORT = 3306;

	@SuppressWarnings("serial")
	public static void main(String[] args) throws SQLException, IOException {
		Connection connection = DbUtil.getConnection("localhost", PORT, SCHEMA, USER_NAME, PASSWORD);
//		 System.out.println(DbUtil.get(connection, "SELECT * FROM app_menu WHERE  pk_id=?" ,6));
//	     System.out.println(DbUtil.getGeneratedKey(connection, "INSERT INTO app_menu(lang, name, description)" + "VALUES(?, ?, ?)", "Eng" ,"Amazon" ,"This is from java"));
//		 System.out.println(DbUtil.update(connection, "UPDATE app_menu SET name=? WHERE pk_id=?", "Facebook",7));
//	     System.out.println(DbUtil.getMapList(connection, "SELECT * FROM practice.app_menu"));
//		 System.out.println(DbUtil.update(connection, "DELETE FROM app_menu WHERE  pk_id=?",7));
		DbUtil.batchUpdate(connection, "INSERT INTO app_menu(lang, name, description)" + "VALUES(?, ?, ?)",
				new ArrayList<List<Object>>() {
					{
						add(Arrays.asList("Eng", "Amazon", "This is from java"));
						add(Arrays.asList("Tel", "Google", "This is from java"));
						add(Arrays.asList("Hindi", "Flipkart", "This is from java"));
					}
				});
		// System.out.println(tableLists);
//		DbUtil.batchUpdate(connection, "UPDATE student SET name=? WHERE id=?" , Arrays.asList(tableLists).get(0));
		DbUtil.closeConnection(connection);

	}

}
