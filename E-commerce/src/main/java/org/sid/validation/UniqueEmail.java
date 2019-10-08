package org.sid.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( {ElementType.TYPE,ElementType.FIELD,ElementType.ANNOTATION_TYPE} ) //,ElementType.ANNOTATION_TYPE
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
@Documented 
public @interface UniqueEmail {
	
	String message() default "Email already exist ";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
