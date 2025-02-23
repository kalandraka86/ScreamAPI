package com.example.ProjectSpringBoot.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_actors")
@IdClass(MovieActorId.class)
public class MovieActor {

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    public MovieActor() {}

    public MovieActor(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }

    // Getters y setters
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
