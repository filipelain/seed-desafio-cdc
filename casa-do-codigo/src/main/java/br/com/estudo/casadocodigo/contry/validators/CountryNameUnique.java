package br.com.estudo.casadocodigo.contry.validators;

import jakarta.validation.Constraint;

@Constraint(validatedBy = CountryNameUniqueValidation.class)
public @interface CountryNameUnique {

    String message() default "Country name must be unique";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
