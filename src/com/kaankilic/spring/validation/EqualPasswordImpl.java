package com.kaankilic.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class EqualPasswordImpl implements ConstraintValidator<EqualPassword, String> {

	private String password;

	@Override
	public void initialize(EqualPassword constraint) {

		password = constraint.password();

	}

	@Override
	public boolean isValid(String confirmPassword, ConstraintValidatorContext context) {
		return password.equals(confirmPassword);
	}

}
