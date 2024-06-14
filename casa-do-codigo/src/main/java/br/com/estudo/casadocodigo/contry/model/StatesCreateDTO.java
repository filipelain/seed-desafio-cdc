package br.com.estudo.casadocodigo.contry.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatesCreateDTO {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;
}
