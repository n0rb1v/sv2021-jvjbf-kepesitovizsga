package training360.guinessapp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeValidator implements ConstraintValidator<IsValidTime, LocalDate> {
    @Override
    public boolean isValid(LocalDate time, ConstraintValidatorContext constraintValidatorContext) {
        return time != null &&
                time.isBefore(LocalDate.now());
    }
}
