package com.yujiyamamoto64.market7.services.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClientInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientInsert {

	String message() default "Validation error";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
