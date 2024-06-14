package br.com.estudo.casadocodigo.contry.validators;

import br.com.estudo.casadocodigo.contry.services.CountryService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CountryNameUniqueValidation implements ConstraintValidator<CountryNameUnique, String> {

    private final CountryService countryService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !countryService.existsByName(s);
    }
}
