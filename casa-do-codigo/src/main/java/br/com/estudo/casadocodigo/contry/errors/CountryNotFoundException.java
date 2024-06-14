package br.com.estudo.casadocodigo.contry.errors;

public class CountryNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Country not found";
    public CountryNotFoundException(String message) {
        super(String.format("%s: %s", MESSAGE, message));
    }
}
