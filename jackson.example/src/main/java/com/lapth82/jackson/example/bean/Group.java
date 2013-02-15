package com.lapth82.jackson.example.bean;

import java.util.List;

public class Group {

	private String groupName;
	
	private List<User> lstUser;

	public Group() {}
	
	public Group(String groupName, List<User> lstUser) {
		super();
		this.groupName = groupName;
		this.lstUser = lstUser;
	}

	public List<User> getLstUser() {
		return lstUser;
	}

	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		String rt = "Groupname: " + groupName + "\nlstUser:\n";
		
		for (User user : lstUser) {
			rt = rt + user.toString() + "\n";
		}
		
		return rt;
	}
}
