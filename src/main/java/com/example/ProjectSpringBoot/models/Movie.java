package com.example.ProjectSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título de la película no puede estar vacío")
    @Size(min = 1, max = 255, message = "El título debe tener entre 1 y 255 caracteres")
    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    // Se cambió a FetchType.EAGER para cargar los detalles automáticamente
    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference // Evita la recursión infinita en la serialización
    private MovieDetail movieDetail;

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    // Método auxiliar para establecer la relación bidireccional
    public void addMovieDetail(MovieDetail detail) {
        this.movieDetail = detail;
        detail.setMovie(this);
    }

    // Getters y setters
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
