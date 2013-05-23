package com.lapth82.jut.mockito.intefaces;

public interface IAccount {
	public void setLoggedIn(boolean value);
	public boolean passwordMatches(String candidate);
	public void setRevoked(boolean value);
	public boolean isLoggedIn();
	public boolean isRevoked();
}
