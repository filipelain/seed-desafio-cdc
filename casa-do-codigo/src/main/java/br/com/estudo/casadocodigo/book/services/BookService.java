package br.com.estudo.casadocodigo.book.services;

import br.com.estudo.casadocodigo.author.models.Author;
import br.com.estudo.casadocodigo.author.services.AuthorService;
import br.com.estudo.casadocodigo.book.model.Book;
import br.com.estudo.casadocodigo.book.model.BookCreateDto;
import br.com.estudo.casadocodigo.book.repositories.BookRepository;
import br.com.estudo.casadocodigo.category.model.Category;
import br.com.estudo.casadocodigo.category.services.CategoryService;
import java.util.List;
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

    public List<Book> findAll() {
        return bookRepository.findAll();
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


}
