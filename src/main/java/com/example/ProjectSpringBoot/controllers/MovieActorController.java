package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.MovieActor;
import com.example.ProjectSpringBoot.services.MovieActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-actors")
@Tag(name = "Movie-Actors", description = "Endpoints para gestionar los actores de las películas concretas")
public class MovieActorController {

    @Autowired
    private MovieActorService movieActorService;

    @Operation(summary = "Obtener todos los actores de películas", description = "Devuelve la lista completa de actores asociados a películas")
    @GetMapping
    public List<MovieActor> getAllMovieActors() {
        return movieActorService.getAllMovieActors();
    }

    @Operation(summary = "Crear relación entre película y actor", description = "Asocia un actor a una película")
    @PostMapping
    public ResponseEntity<MovieActor> createMovieActor(@RequestBody MovieActor movieActor) {
        return new ResponseEntity<>(movieActorService.createMovieActor(movieActor), HttpStatus.CREATED);
    }

    @Operation(summary = "Eliminar relación entre película y actor", description = "Elimina la relación entre un actor y una película por sus ID")
    @DeleteMapping("/{movieId}/{actorId}")
    public ResponseEntity<Void> deleteMovieActor(@PathVariable Long movieId, @PathVariable Long actorId) {
        movieActorService.deleteMovieActor(movieId, actorId);
        return ResponseEntity.noContent().build();
    }
}
