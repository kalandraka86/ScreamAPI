package com.example.ProjectSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "movie_details")
public class MovieDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference // Evita la recursión infinita en la serialización
    @OneToOne
    @JoinColumn(name = "movie_id", nullable = false, unique = true)
    private Movie movie;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false, length = 50)
    private String language;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
