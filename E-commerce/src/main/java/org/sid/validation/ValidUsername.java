package org.sid.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.sid.validation.EmailValidator;

// 
@Target( {ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE} ) //,ElementType.ANNOTATION_TYPE
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserNameValidator.class)
@Documented 
public @interface ValidUsername {
	
	String message() default "Invalid Username";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
