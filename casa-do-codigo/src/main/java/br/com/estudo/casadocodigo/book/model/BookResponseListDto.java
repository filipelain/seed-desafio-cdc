package br.com.estudo.casadocodigo.book.model;

import java.util.UUID;
import lombok.Data;

@Data
public class BookResponseListDto {

    private UUID id;
    private String title;

    public BookResponseListDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }
}
