package com.lapth82.springmvc.form.jsr303.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//http://docs.jboss.org/hibernate/validator/4.2/reference/en-US/html/validator-customconstraints.html

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=CodeValidatorImpl.class)
public @interface CodeValidator {
	String message() default "{code.not.correct}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
