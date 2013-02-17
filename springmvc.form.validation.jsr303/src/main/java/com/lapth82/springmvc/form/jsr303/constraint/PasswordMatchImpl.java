package com.lapth82.springmvc.form.jsr303.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;


public class PasswordMatchImpl implements ConstraintValidator<PasswordMatch, Object> {

	private String password;
	
	private String repassword;
	
	@Override
	public void initialize(PasswordMatch pm) {
		password = pm.password();
		repassword = pm.repassword();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext ctx) {
		
		try {
			// get field value
			Object pw = BeanUtils.getProperty(obj, password);
        	Object rpw = BeanUtils.getProperty(obj, repassword);

        	return pw != null && rpw != null && pw.equals(rpw);
		} catch (Exception ex) {
			return false;
		}
	}
}
