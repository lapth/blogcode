package com.lapth82.springmvc.form.taglib.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lapth82.springmvc.form.taglib.bean.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName", "Firstname is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastName", "LastName is required.");
        
        User user = (User) obj;
        if (!user.getPassword().equals(user.getRepassword())) {
        	errors.rejectValue("password", "notmatch.password");
        }
	}
}
