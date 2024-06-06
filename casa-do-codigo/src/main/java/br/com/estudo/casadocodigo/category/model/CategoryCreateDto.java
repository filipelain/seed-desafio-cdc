package br.com.estudo.casadocodigo.category.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryCreateDto {
    @NotNull(message = "Category name is required")
    @NotBlank(message = "Category name cannot be blank")
    private String name;
}
