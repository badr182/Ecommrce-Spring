package org.sid.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
// PasswordMatches
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE}) // , ElementType.FIELD ,ElementType.ANNOTATION_TYPE
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented 
public @interface PasswordMatches {
	
	String message() default  "{errors.user.password}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
