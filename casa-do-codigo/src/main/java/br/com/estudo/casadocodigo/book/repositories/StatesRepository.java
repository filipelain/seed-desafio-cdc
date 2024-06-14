package br.com.estudo.casadocodigo.book.repositories;

import br.com.estudo.casadocodigo.contry.model.States;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesRepository extends JpaRepository<States, UUID> {
    Optional<List<States>> findByCountry_Id(UUID uuid);
}
