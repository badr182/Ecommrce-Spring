package org.sid.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sid.dao.UserRepository;
import org.sid.entites.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
  
  
  @Autowired
  private UserRepository userRepository;  
  
  
  @Override
  public void initialize(UniqueEmail constraintAnnotation) {       
  }
  
  @Override
  public boolean isValid(String email, ConstraintValidatorContext context){   
      return (emailExist(email));
  } 
  
  private boolean emailExist(String email) {
		User user = userRepository.findByEmail(email);
		if( user != null  ) {
			return true ;
		}
		return false;
	}
}