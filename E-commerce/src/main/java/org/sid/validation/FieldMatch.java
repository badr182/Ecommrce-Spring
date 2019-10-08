package org.sid.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import javax.validation.Payload;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
public @interface FieldMatch {
	
	String message() default "The fields must match";
	Class<?>[] groups() default {} ;
    Class<? extends Payload >[] payload() default {};
    
    String first();
    String second();
	
}
