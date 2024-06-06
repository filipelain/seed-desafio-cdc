package br.com.estudo.casadocodigo.category.erros;

public class CategoryCreateException extends RuntimeException {
    private static final String MESSAGE = "Error creating category";


    public CategoryCreateException(String message) {
        super(String.format("%s: %s", MESSAGE, message));
    }

}
