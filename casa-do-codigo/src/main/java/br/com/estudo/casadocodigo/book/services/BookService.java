package br.com.estudo.casadocodigo.book.services;

import static br.com.estudo.casadocodigo.book.mappers.BookMappers.bookToBookResponseListDto;
import static br.com.estudo.casadocodigo.common.UUIDFunction.getUUID;

import br.com.estudo.casadocodigo.author.models.Author;
import br.com.estudo.casadocodigo.author.services.AuthorService;
import br.com.estudo.casadocodigo.book.errors.BookNotFoundExceptions;
import br.com.estudo.casadocodigo.book.model.Book;
import br.com.estudo.casadocodigo.book.model.BookCreateDto;
import br.com.estudo.casadocodigo.book.model.BookResponseListDto;
import br.com.estudo.casadocodigo.book.repositories.BookRepository;
import br.com.estudo.casadocodigo.category.model.Category;
import br.com.estudo.casadocodigo.category.services.CategoryService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public Book create(BookCreateDto bookCreate) {
        Author author = getAuthor(bookCreate.getAuthor());
        Category category = getCategory(bookCreate.getCategory());
        var book = new Book(bookCreate, author, category);
        return save(book);
    }

    public List<BookResponseListDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookToBookResponseListDto)
                .toList();
    }

    private Book save(Book book) {
        return bookRepository.save(book);
    }

    private Author getAuthor(String authorId) {
        return authorService.findById(authorId);
    }

    private Category getCategory(String categoryId) {
        return categoryService.findById(categoryId);
    }


    public Book findById(String id) {
        return Optional.ofNullable(id)
                .flatMap(getUUID)
                .flatMap(bookRepository::findById)
                .orElseThrow(() -> new BookNotFoundExceptions(id));
    }
}
