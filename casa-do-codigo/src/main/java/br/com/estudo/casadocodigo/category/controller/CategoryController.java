package br.com.estudo.casadocodigo.category.controller;


import br.com.estudo.casadocodigo.category.model.Category;
import br.com.estudo.casadocodigo.category.model.CategoryCreateDto;
import br.com.estudo.casadocodigo.category.services.CategoryService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> list() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryCreateDto categoryCreate) {
        return Optional.ofNullable(categoryCreate)
                .map(categoryService::create)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}
