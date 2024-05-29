package br.com.estudo.casadocodigo.author.erros;

public class AuthorEmailDuplicatedException extends RuntimeException {
    private static final String MESSAGE = "Email already exists";

    public AuthorEmailDuplicatedException(String email) {
        super(String.format("%s: %s", MESSAGE, email));
    }
}
