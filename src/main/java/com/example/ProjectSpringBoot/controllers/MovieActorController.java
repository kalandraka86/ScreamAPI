package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.MovieActor;
import com.example.ProjectSpringBoot.services.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-actors")
public class MovieActorController {

    @Autowired
    private MovieActorService movieActorService;

    @GetMapping
    public List<MovieActor> getAllMovieActors() {
        return movieActorService.getAllMovieActors();
    }

    @PostMapping
    public ResponseEntity<MovieActor> createMovieActor(@RequestBody MovieActor movieActor) {
        return new ResponseEntity<>(movieActorService.createMovieActor(movieActor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{movieId}/{actorId}")
    public ResponseEntity<Void> deleteMovieActor(@PathVariable Long movieId, @PathVariable Long actorId) {
        movieActorService.deleteMovieActor(movieId, actorId);
        return ResponseEntity.noContent().build();
    }
}
