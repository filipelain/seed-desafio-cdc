package br.com.estudo.casadocodigo.book.model;

import br.com.estudo.casadocodigo.author.models.Author;
import br.com.estudo.casadocodigo.category.model.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "TB_BOOK")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDateTime publicationDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;


    public Book(BookCreateDto bookCreate, Author author, Category category) {
        this.title = bookCreate.getTitle();
        this.resume = bookCreate.getResume();
        this.summary = bookCreate.getSummary();
        this.price = bookCreate.getPrice();
        this.pages = bookCreate.getPages();
        this.isbn = bookCreate.getIsbn();
        this.publicationDate = bookCreate.getPublicationDate();
        this.author = author;
        this.category = category;
    }
}
