package com.lapth82.springmvc.form.taglib.textbox.bean;

public class User {

	// a text box
	private String name;

	// textarea
	private String about;
	
	// hidden
	private String hidden;
	
	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
