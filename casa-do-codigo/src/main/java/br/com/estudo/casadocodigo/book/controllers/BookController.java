package br.com.estudo.casadocodigo.book.controllers;


import br.com.estudo.casadocodigo.book.model.Book;
import br.com.estudo.casadocodigo.book.model.BookCreateDto;
import br.com.estudo.casadocodigo.book.model.BookResponseListDto;
import br.com.estudo.casadocodigo.book.services.BookService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public ResponseEntity<List<BookResponseListDto>> list() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable String id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Book> create(@Valid @RequestBody BookCreateDto bookCreate) {
        return ResponseEntity.ok(bookService.create(bookCreate));
    }


}
