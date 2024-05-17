package rs.ac.singidunum.bg.vezbe1.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target({ElementType.METHOD ,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraints{
    String message() default "Invalid phone number!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
