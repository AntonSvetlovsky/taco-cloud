package org.example.tacos.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface ValidPassword {

    String message() default "The password confirmation does not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
