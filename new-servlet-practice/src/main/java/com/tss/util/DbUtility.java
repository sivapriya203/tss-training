package com.tss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtility {

	/**
	 * This method gives database connection to all methods
	 * 
	 * @param host
	 * @param port
	 * @param schema
	 * @param userName
	 * @param password
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection(String host, int port, String schema, String userName, String password) throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + schema, userName,
				password);
		// connection.setAutoCommit(false);
		return connection;
	}

	/**
	 * This method give close data base connection to all methods
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void getClose(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * This method is used to insert the data into the table
	 * 
	 * @param connection
	 * @param sql
	 * @param name
	 * @param phoneNo
	 * @param emailId
	 * @param location
	 * @return String
	 */
	public static String insert(Connection connection, String sql, Object... objects) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			int index = 0;
			for (Object values : objects) {
				statement.setObject(++index, values);
			}
			int rows = statement.executeUpdate();
			if (rows > 0) {
				return "Row is inserted";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	/**
	 * This method used to read the data from the table
	 * 
	 * @param connection
	 * @param sql
	 * @return String
	 */
	public static String select(Connection connection, String sql,Object...objects) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String phoneNo = result.getString("phoneNo");
				String emailId = result.getString("emailId");
				String location = result.getString("location");
				String data = id + ":" + name + "," + phoneNo + "," + emailId + "," + location;
				return data.toString();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "";
	}

	/**
	 * 
	 * @param connection
	 * @param sql
	 * @param name
	 * @return String
	 */
	public static String update(Connection connection, String sql, Object object) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, object);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				return "update successfully";
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "update successfully";
	}

	/**
	 * 
	 * @param connection
	 * @param sql
	 * @param name
	 * @return String
	 */
	public static String delete(Connection connection, String sql, Object obj) {
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setObject(1, obj);
			int rows = statement.executeUpdate();
			if (rows > 0) {
				return "Row is deleted";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "Row is deleted";
	}
}