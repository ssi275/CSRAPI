package com.csr.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "USER")

public class User {

	@Id
	private String userId;
	private String userName;
	private String password;
	private String userType;
	private boolean userStatus;
	
	
	public User() {
		super();
	}

	
	
	public User(String userName, String password, String userType, String userId, boolean userStatus) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.userId = userId;
		this.userStatus = userStatus;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isUserStatus() {
		return userStatus;
	}

	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}


	
	
}
