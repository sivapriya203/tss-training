package com.tss.service;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tss.dao.UserDao;
import com.tss.pojo.User;
import com.tss.util.Utility;

public class UserService {
	private UserDao dao;

	public static UserService init(Connection connection) {
		UserService svc = new UserService();
		svc.dao = UserDao.init(connection);
		return svc;
	}

	public List<Map<String, Object>> list() {
		return dao.list();
	}

	public Map<String, Object> add(User user) {
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		String phoneNo = user.getPhoneNo();
		int id = 0;
		if (Utility.isValidMobileNo(phoneNo)) {
			if (Utility.hasData(dao.get(phoneNo)))
				res.put("errors", "Phone number already exists");
			else
				id = dao.add(user);
		} else {
			res.put("errors", "Invalid phone number");
		}
		if (id > 0)
			res.put("success", true);
		return res;
	}

	public Map<String, Object> update(User user) {
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		int id = dao.update(user);
		if (id < 0)
			res.put("errors", "Unable to update");
		return res;
	}
	
	public Map<String, Object> delete(String phoneNo) {
		Map<String, Object> res = new LinkedHashMap<String, Object>();
		int id = dao.delete(phoneNo);
		if (id < 0)
			res.put("errors", "Unable to delete");
		return res;
	}

	public Map<String, Object> get(String phoneNo) {
		return dao.get(phoneNo);
	}
}
