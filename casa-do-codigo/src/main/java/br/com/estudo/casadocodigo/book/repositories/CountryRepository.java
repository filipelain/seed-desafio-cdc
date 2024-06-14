package br.com.estudo.casadocodigo.book.repositories;

import br.com.estudo.casadocodigo.contry.model.Country;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, UUID> {

    public boolean existsByName(String name);
}
