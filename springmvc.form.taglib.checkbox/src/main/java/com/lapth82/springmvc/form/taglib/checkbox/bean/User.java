package com.lapth82.springmvc.form.taglib.checkbox.bean;

public class User {

	// a check box
	private boolean married;

	// checkboxs
	private String[] hobbies;

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
}
