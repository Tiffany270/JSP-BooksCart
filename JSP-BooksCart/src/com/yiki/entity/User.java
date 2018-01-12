package com.yiki.entity;

public class User {

	private String username;
	private int password;
	private String realname;
	private String sex;
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", realname=" + realname + ", sex=" + sex
				+ ", address=" + address + "]";
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
