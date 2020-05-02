package com.norha.spring.model;

public class User {
	int userID;
	String name;
	String email;
	String password;
	
	public User() {
	}

	public User(int userID, String name, String email) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", name=" + name + ", email=" + email +  "]";
	}

	
}
