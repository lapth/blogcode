package com.lapth82.springmvc.form.jsr303.constraint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeValidatorImpl implements ConstraintValidator<CodeValidator, String> {

	@Override
	public void initialize(CodeValidator arg0) {
	}

	@Override
	public boolean isValid(String codeValue, ConstraintValidatorContext ctx) {
		return checkNull(codeValue, ctx) && checkMatched(codeValue, ctx);
	}

	private boolean checkNull(String codeValue, ConstraintValidatorContext ctx) {
		boolean isValid;

		if (codeValue == null || codeValue.equals("")) {
			isValid = false;
		} else {
			isValid = true;
		}
		
		if (!isValid) {
			ctx.disableDefaultConstraintViolation();
			ctx.buildConstraintViolationWithTemplate("{code.required}").addConstraintViolation();
		}
		
		return isValid;
	}
	
	private boolean checkMatched(String codeValue, ConstraintValidatorContext ctx) {
		Pattern pattern = Pattern.compile("[0-9a-zA-Z]*");
		
		Matcher matcher = pattern.matcher(codeValue);
		
		if (!matcher.matches()) {
			ctx.disableDefaultConstraintViolation();
			ctx.buildConstraintViolationWithTemplate("{code.contain.only}").addConstraintViolation();
			
			return false;
		} else {
			return true;
		}
	}
}
