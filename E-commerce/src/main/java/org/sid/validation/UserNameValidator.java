package org.sid.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<ValidUsername, String> {
   
  
  @Override
  public void initialize(ValidUsername constraintAnnotation) {       
  }
  
  @Override
  public boolean isValid(String userName, ConstraintValidatorContext context){
	  return userName.equals("BADR");
      
  } 


}