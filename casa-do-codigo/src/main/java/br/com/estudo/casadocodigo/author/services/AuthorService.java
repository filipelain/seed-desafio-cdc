package br.com.estudo.casadocodigo.author.services;

import br.com.estudo.casadocodigo.author.erros.AuthorNotFoundException;
import br.com.estudo.casadocodigo.author.models.Author;
import br.com.estudo.casadocodigo.author.models.AuthorCreateDto;
import br.com.estudo.casadocodigo.author.repositories.AuthorRepository;
import br.com.estudo.casadocodigo.common.UUIDFunction;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author create(AuthorCreateDto authorCreate) {
        Author author = new Author(authorCreate);
        return save(author);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author findById(String id) {
        return Optional.of(id)
                .flatMap(UUIDFunction.getUUID)
                .flatMap(authorRepository::findById)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public boolean existsByEmail(String email) {
        return authorRepository.existsByEmail(email);
    }

}
