package br.com.estudo.casadocodigo.category.services;

import static br.com.estudo.casadocodigo.common.UUIDFunction.getUUID;

import br.com.estudo.casadocodigo.category.erros.CategoryCreateException;
import br.com.estudo.casadocodigo.category.model.Category;
import br.com.estudo.casadocodigo.category.model.CategoryCreateDto;
import br.com.estudo.casadocodigo.category.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category create(CategoryCreateDto categoryCreate) {
        return Optional.of(categoryCreate)
                .map(Category::new)
                .map(categoryRepository::save)
                .orElseThrow(()-> new CategoryCreateException("Error creating category"));
    }

    public Category findById(String categoryId) {
        return Optional.of(categoryId)
                .flatMap(getUUID)
                .flatMap(categoryRepository::findById)
                .orElseThrow(() -> new CategoryCreateException("Category not found"));
    }
}
