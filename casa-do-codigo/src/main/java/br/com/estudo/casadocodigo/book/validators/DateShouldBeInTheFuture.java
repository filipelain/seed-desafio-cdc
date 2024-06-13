package br.com.estudo.casadocodigo.book.validators;

import jakarta.validation.Constraint;

@Constraint(validatedBy = DateShouldBeInTheFutureValidation.class)
public @interface DateShouldBeInTheFuture {

    String message() default "Date should be in the future";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
