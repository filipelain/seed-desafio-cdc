package br.com.estudo.casadocodigo.book.model;

import br.com.estudo.casadocodigo.book.validators.DateShouldBeInTheFuture;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BookCreateDto {

    @NotNull(message = "Title is required")
    @NotBlank(message = "Title is required")
    private String title;
    @NotNull(message = "Resume is required")
    @NotBlank(message = "Resume is required")
    @Size(max = 500, message = "Resume must be less than 500 characters")
    private String resume;
    private String summary;
    @NotNull(message = "Price is required")
    @Min(value = 20, message = "Price must be at least 20")
    private BigDecimal price;
    @NotNull(message = "Pages is required")
    @Min(value = 100, message = "Pages must be at least 100")
    private Integer pages;
    @NotNull(message = "ISBN is required")
    private String isbn;
    @NotNull(message = "Publication date is required")
    @DateShouldBeInTheFuture()
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime publicationDate;
    @NotNull(message = "Category is required")
    private String category;
    @NotNull(message = "Author is required")
    private String author;


}
