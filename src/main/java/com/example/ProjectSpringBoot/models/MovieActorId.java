package com.example.ProjectSpringBoot.models;

import java.io.Serializable;
import java.util.Objects;

// Cuando tienes una relación muchos a muchos, como en este caso entre Movie y Actor, debes definir una clave primaria compuesta.

public class MovieActorId implements Serializable {
    private Long movie;
    private Long actor;

    // Constructor vacío para JPA
    public MovieActorId() {}

    public MovieActorId(Long movie, Long actor) {
        this.movie = movie;
        this.actor = actor;
    }

    // Getters y setters
    public Long getMovie() {
        return movie;
    }

    public void setMovie(Long movie) {
        this.movie = movie;
    }

    public Long getActor() {
        return actor;
    }

    public void setActor(Long actor) {
        this.actor = actor;
    }

    // equals y hashCode deben ser implementados para comparar correctamente las claves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActorId that = (MovieActorId) o;
        return Objects.equals(movie, that.movie) && Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, actor);
    }
}
