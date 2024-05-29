package br.com.estudo.casadocodigo.author.validators;

import br.com.estudo.casadocodigo.author.services.AuthorService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailNotDuplicatedValidator implements ConstraintValidator<EmailNotDuplicated, String> {
    private final AuthorService authorService;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !authorService.existsByEmail(s);
    }
}
