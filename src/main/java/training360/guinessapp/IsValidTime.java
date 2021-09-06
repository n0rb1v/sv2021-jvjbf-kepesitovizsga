package training360.guinessapp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeValidator.class)
public @interface IsValidTime {
    String message() default "must be in the past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
