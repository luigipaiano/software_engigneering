package it.unisalento.myairbnb.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<UserDTONameConstraint, String> {
	
	String name;
	

	@Override
	public void initialize(UserDTONameConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		name = constraintAnnotation.name();
	}
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (value.equals(name))
				return false;
		else return true;
	}

}
