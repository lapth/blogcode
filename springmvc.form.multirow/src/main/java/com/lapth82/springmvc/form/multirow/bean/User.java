package com.lapth82.springmvc.form.multirow.bean;


public class User {

	// a text box
	private String name;
	
	// checkboxs
	private String[] hobbies;
	
	// a radio
	private String sex;
	
	// options
	private String[] countries;
	
	public User() {
		this.name = "Lap";
		this.sex = "M";
		this.hobbies = new String[] {"1"};
		this.countries = new String[] {"3"};
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getCountries() {
		return countries;
	}

	public void setCountries(String[] countries) {
		this.countries = countries;
	}

}
