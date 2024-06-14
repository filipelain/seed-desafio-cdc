package br.com.estudo.casadocodigo.contry.model;

import br.com.estudo.casadocodigo.contry.validators.CountryNameUnique;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CountryCreateDto {

    @NotNull(message = "Name is required")
    @CountryNameUnique()
    private String name;

}
