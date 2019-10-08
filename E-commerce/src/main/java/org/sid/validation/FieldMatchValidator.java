package org.sid.validation;

import javax.validation.ConstraintValidator;

// import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sid.web.dto.UserDto;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{

	
	 private String firstFieldName;
	    private String secondFieldName;
	    private String message;

	    @Override
	    public void initialize(final FieldMatch constraintAnnotation) {
	        firstFieldName = constraintAnnotation.first();
	        secondFieldName = constraintAnnotation.second();
	        message = constraintAnnotation.message();	        
	    }

	    @Override
	    public boolean isValid(Object obj, final ConstraintValidatorContext context) {
	    	UserDto user = (UserDto) obj ;
	        boolean valid = true;
	        try
	        {
//	            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
//	            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);
	        	//user.getPassword() ; 
	            //valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
	        	System.out.println(firstFieldName);
	        	valid  = user.getPassword().equals(user.getMatchingPassword()) ;
	        }
	        catch (final Exception ignore)
	        {
	            // ignore
	        }

	        if (!valid){
	            context.buildConstraintViolationWithTemplate(message)
	                    .addPropertyNode(firstFieldName)
	                    .addConstraintViolation()
	                    .disableDefaultConstraintViolation();
	        }

	        return valid;
	    } 
}
