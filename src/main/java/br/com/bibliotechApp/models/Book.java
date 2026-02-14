package br.com.bibliotechApp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tbl_books")
public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    @NotBlank(message = "O título não pode estar vazio")
    private String title;

    @Column(nullable = false, length = 120)
    @NotBlank(message = "O nome do autor não pode estar vazio")
    private String author;

    @Column(nullable = false, length = 300)
    @NotBlank(message = "A sinopse não pode estar vazia")
    private String synopsis;

    @Column(nullable = false)
    @NotNull(message = "A data de lançamento é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Book () {}

    public Book(Long id, String title, String author, String synopsis, LocalDate releaseDate, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.synopsis = synopsis;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
