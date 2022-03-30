package com.tss.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.tss.pojo.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public static UserDao init(Connection connection) {
		UserDao dao = new UserDao();
		dao.jdbcTemplate = new JdbcTemplate();
		dao.jdbcTemplate.setDataSource(new SingleConnectionDataSource(connection, false));
		return dao;
	}

	public List<Map<String, Object>> list() {
		return jdbcTemplate.queryForList("SELECT * FROM user");
	}

	public int add(User user) {
		return jdbcTemplate.update("INSERT INTO user(name, phoneNo) VALUES(?,?)", user.getName(), user.getPhoneNo());
	}

	public int update(User user) {
		return jdbcTemplate.update("UPDATE user SET name=? WHERE phoneNo=?", user.getName(), user.getPhoneNo());
	}

	public int delete(String phoneNo) {
		return jdbcTemplate.update("DELETE FROM user WHERE phoneNo=?", phoneNo);
	}

	public Map<String, Object> get(String phoneNo) {
		return jdbcTemplate.queryForMap("SELECT * FROM user WHERE phoneNo=?", phoneNo);

	}
	
}
