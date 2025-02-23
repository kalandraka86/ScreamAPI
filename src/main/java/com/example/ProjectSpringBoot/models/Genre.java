package com.example.ProjectSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del género no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre del género debe tener entre 3 y 50 caracteres")
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private List<Movie> movies;

    public Genre() {}

    public Genre(String name) {
        this.name = name;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
