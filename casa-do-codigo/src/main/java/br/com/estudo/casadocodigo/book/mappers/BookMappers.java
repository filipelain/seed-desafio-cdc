package br.com.estudo.casadocodigo.book.mappers;

import br.com.estudo.casadocodigo.book.model.Book;
import br.com.estudo.casadocodigo.book.model.BookResponseListDto;
import java.util.function.Function;

public class BookMappers {

    private BookMappers() {
        throw new IllegalStateException("Utility class");
    }

    public static final Function<Book, BookResponseListDto> bookToBookResponseListDto = book -> new BookResponseListDto(book.getId(), book.getTitle());
}
