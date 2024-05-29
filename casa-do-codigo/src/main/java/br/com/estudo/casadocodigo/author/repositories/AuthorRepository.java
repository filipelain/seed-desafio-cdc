package br.com.estudo.casadocodigo.author.repositories;


import br.com.estudo.casadocodigo.author.models.Author;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
