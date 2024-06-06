package br.com.estudo.casadocodigo.category.repositories;

import br.com.estudo.casadocodigo.category.model.Category;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, UUID> { }
