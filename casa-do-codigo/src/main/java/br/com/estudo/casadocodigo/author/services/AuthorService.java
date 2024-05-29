package br.com.estudo.casadocodigo.author.services;

import br.com.estudo.casadocodigo.author.erros.AuthorNotFoundException;
import br.com.estudo.casadocodigo.author.models.Author;
import br.com.estudo.casadocodigo.author.models.AuthorCreateDto;
import br.com.estudo.casadocodigo.author.repositories.AuthorRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        return getUUID(id)
                .flatMap(authorRepository::findById)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    private Optional<UUID> getUUID(String id) {
        try {
            return Optional.of(UUID.fromString(id));
        } catch (Exception e) {
            return Optional.empty();
        }

    }

    public boolean existsByEmail(String email) {
        return authorRepository.existsByEmail(email);
    }

}
