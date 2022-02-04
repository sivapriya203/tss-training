package com.tss.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.tss.util.DbUtility;

public class CrudOperations {
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "The@1234";
	public static final String SCHEMA = "practice";
	public static final int PORT = 3306;

	public static void main(String[] args) throws SQLException {
		Connection connection = DbUtility.getConnection("localhost", PORT, SCHEMA, USER_NAME, PASSWORD);
       System.out.println(DbUtility.insert(connection, "INSERT INTO student(name, phoneNo, emailId, location)" + "VALUES(?, ?, ?, ?)", "Sravyaa4nii" ,"809090900652" ,"sravyyaani19@gmail.com", "hydearabadii"));
        System.out.println(DbUtility.select(connection, "SELECT * FROM student"));
		System.out.println(DbUtility.update(connection,
				"UPDATE student SET name=? WHERE emailId='priya12378@gmail.com'", "Priyaaaaaa"));
		// System.out.println(DbUtility.delete(connection, "DELETE FROM student WHERE "emailId=?", "priya12378@gmail.com"));
		DbUtility.getClose(connection);

	}
}