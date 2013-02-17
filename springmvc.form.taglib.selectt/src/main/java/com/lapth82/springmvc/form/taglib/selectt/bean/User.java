package com.lapth82.springmvc.form.taglib.selectt.bean;

public class User {

	// a dropdown
	private String skill1;

	// a dropdown by using options tag
	private String skill2;
	
	// multi select = list box
	private String[] skills;

	public String getSkill1() {
		return skill1;
	}

	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}

	public String getSkill2() {
		return skill2;
	}

	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}
}