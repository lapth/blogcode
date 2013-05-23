package com.lapth82.jut.mockito.intefaces;

import com.lapth82.jut.mockito.bean.User;

public interface IUserManager {

	public User getUser(String userId);
	
	public void setUser(User user);
	
}
