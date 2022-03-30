package com.tss.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String name;
	private String phoneNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	

	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNo=" + phoneNo + "]";
	}

}
