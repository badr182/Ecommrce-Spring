package org.sid.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sid.web.dto.UserDto;
import org.sid.validation.PasswordMatches;

public class PasswordMatchesValidator

	implements ConstraintValidator<PasswordMatches, Object>{

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto user = (UserDto) obj ;
		return user.getPassword().equals(user.getMatchingPassword()) ;
	}
	
	
	
}
