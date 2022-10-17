package org.example.tacos.valid;

import org.example.tacos.entity.RegistrationForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, RegistrationForm> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegistrationForm registrationForm, ConstraintValidatorContext context) {
        return registrationForm.getPassword().equals(registrationForm.getConfirm());
    }

}
