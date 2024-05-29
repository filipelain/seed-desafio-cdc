package br.com.estudo.casadocodigo.author.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "TB_AUTHOR")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String description;

    @CreatedDate
    private LocalDateTime createAt;

    public Author(AuthorCreateDto authorCreate) {
        this.name = authorCreate.getName();
        this.email = authorCreate.getEmail();
        this.description = authorCreate.getDescription();
    }
}
