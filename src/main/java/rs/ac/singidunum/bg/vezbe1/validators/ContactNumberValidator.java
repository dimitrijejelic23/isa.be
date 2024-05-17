package rs.ac.singidunum.bg.vezbe1.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Annotation;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraints, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && s.matches("[0-9]+") && (s.length() > 8) && (s.length() < 14);
    }
}
