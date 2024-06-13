package br.com.estudo.casadocodigo.book.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class DateShouldBeInTheFutureValidation implements ConstraintValidator<DateShouldBeInTheFuture, LocalDateTime>{

    @Override
    public boolean isValid(LocalDateTime localDateTime, ConstraintValidatorContext constraintValidatorContext) {
        return !localDateTime.isBefore(LocalDateTime.now());
    }
}

