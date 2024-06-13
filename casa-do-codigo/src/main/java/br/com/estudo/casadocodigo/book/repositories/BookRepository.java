package br.com.estudo.casadocodigo.book.repositories;

import br.com.estudo.casadocodigo.book.model.Book;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
