package com.lapth82.jut.mockito.impl;

import com.lapth82.jut.mockito.bean.User;
import com.lapth82.jut.mockito.intefaces.IUserManager;

public class AutherizationService {

	private IUserManager userManager;

	public AutherizationService(IUserManager userManager) {
		super();
		this.userManager = userManager;
	}
	
	public AutherizationService() {
		super();
		
		//this.userManager = new UserManager();
	}
	
	public User getUser(String id) {
		return this.userManager.getUser(id);
	}
	
	public void setUser(User user) {
		this.userManager.setUser(user);
	}
}
