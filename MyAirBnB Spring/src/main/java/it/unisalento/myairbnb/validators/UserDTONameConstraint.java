package it.unisalento.myairbnb.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint( validatedBy = UserNameValidator.class)
public @interface UserDTONameConstraint {

	 String message() default "Name is not correct";
	 Class<?>[] groups() default {};
	 Class<? extends Payload>[] payload() default {};
	 
	 
	 public String name();

}
