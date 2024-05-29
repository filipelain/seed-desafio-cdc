package br.com.estudo.casadocodigo.author.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Author not found";

    public AuthorNotFoundException(String message) {
        super(String.format("%s: %s", MESSAGE, message));
    }
}
