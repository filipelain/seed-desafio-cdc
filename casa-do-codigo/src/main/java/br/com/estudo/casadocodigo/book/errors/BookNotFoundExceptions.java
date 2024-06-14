package br.com.estudo.casadocodigo.book.errors;

public class BookNotFoundExceptions extends RuntimeException {
    private static final String MESSAGE = "Book not found";

    public BookNotFoundExceptions(String message) {
        super(String.format("%s: %s", MESSAGE, message));
    }
}
