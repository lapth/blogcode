package com.lapth82.springmvc.form.multirow.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lapth82.springmvc.form.multirow.bean.User;
import com.lapth82.springmvc.form.multirow.bean.UserForm;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		UserForm form = (UserForm) obj;

		List<User> lstUser = form.getLstUser();
		
		if (lstUser == null) {
			return;
		}
		
		for (int i = 0; i < lstUser.size(); i++) {
			User user = lstUser.get(i);
			
			if (user.getName() == null || "".equals(user.getName().trim())) {
				errors.rejectValue("lstUser[" + i + "].name", "user.name.required");
			}
		}
	}
}
