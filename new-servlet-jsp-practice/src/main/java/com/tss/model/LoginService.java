package com.tss.model;


public class LoginService {

	/**
	 * 
	 * @param username - user name taking from the user
	 * @param password - password taking from the user
	 * @return boolean
	 */
	public static boolean userLogin(String username, String password) {
		if (username.equals("java1234") && password.equals("1234")) {
			return true;
		} else {
			return false;
		}
	}
	

}
