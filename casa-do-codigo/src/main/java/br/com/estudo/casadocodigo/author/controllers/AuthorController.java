package br.com.estudo.casadocodigo.author.controllers;

import br.com.estudo.casadocodigo.author.models.Author;
import br.com.estudo.casadocodigo.author.models.AuthorCreateDto;
import br.com.estudo.casadocodigo.author.services.AuthorService;
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
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;


    @GetMapping("/")
    public ResponseEntity<List<Author>> list() {
        return ResponseEntity.ok(authorService.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable String id) {
        return ResponseEntity.ok(authorService.findById(id));

    }

    @PostMapping("/")
    public ResponseEntity<Author> create(@RequestBody AuthorCreateDto authorCreate) {
        return ResponseEntity.ok(authorService.create(authorCreate));
    }
}
