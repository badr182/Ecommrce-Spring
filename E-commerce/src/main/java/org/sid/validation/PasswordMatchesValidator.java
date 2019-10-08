package org.sid.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sid.web.dto.UserDto;
//import org.sid.validation.PasswordMatch;



public class PasswordMatchesValidator

	implements ConstraintValidator<PasswordMatches, Object>{

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto user = (UserDto) obj ;
		System.out.println(" *************** ");
		System.out.println(user.getPassword());
		System.out.println(user.getMatchingPassword());
		System.out.println(user.getPassword().equals(user.getMatchingPassword()) );
		return user.getPassword().equals(user.getMatchingPassword()) ;
	}
	
	
	
}
