package com.lapth82.jut.mockito.bean;

public class User {

	private String userId;
	
	private String userName;
	
	private String email;

	public User(String userId, String userName, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		User ou = (User) obj;
		
		return this.userId.equals(ou.getUserId())
				&& this.userName.equals(ou.getUserName())
				&& this.email.equals(ou.getEmail());
	}
}
