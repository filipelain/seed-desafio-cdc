package br.com.estudo.casadocodigo.author.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorCreateDto {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Description is required")
    @Max(value = 400, message = "Description must be less than 400 characters")
    private String description;

}
