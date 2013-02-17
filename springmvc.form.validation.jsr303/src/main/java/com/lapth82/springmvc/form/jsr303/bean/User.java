package com.lapth82.springmvc.form.jsr303.bean;

import org.hibernate.validator.constraints.NotEmpty;

import com.lapth82.springmvc.form.jsr303.constraint.CodeValidator;
import com.lapth82.springmvc.form.jsr303.constraint.PasswordMatch;

@PasswordMatch(password="password", repassword="repassword")
public class User {

	@NotEmpty(message="First Name is required")
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@CodeValidator
	private String code;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String repassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
