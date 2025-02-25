package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.MovieDetail;
import com.example.ProjectSpringBoot.services.MovieDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Movie-Details", description = "Endpoints para gestionar los detalles de las películas concretas")
@RequestMapping("/movie-details")
public class MovieDetailController {

    @Autowired
    private MovieDetailService movieDetailService;

    @Operation(summary = "Obtener todos los detalles de películas", description = "Devuelve la lista completa de detalles de películas")
    @GetMapping
    public List<MovieDetail> getAllMovieDetails() {
        return movieDetailService.getAllMovieDetails();
    }

    @Operation(summary = "Obtener detalle de película por ID", description = "Devuelve el detalle de una película por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<MovieDetail> getMovieDetailById(@PathVariable Long id) {
        Optional<MovieDetail> movieDetail = movieDetailService.getMovieDetailById(id);
        return movieDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nuevo detalle de película", description = "Crea un nuevo detalle de película y lo guarda en la base de datos")
    @PostMapping
    public ResponseEntity<MovieDetail> createMovieDetail(@RequestBody MovieDetail movieDetail) {
        return new ResponseEntity<>(movieDetailService.createMovieDetail(movieDetail), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar detalle de película", description = "Actualiza los detalles de una película existente")
    @PutMapping("/{id}")
    public ResponseEntity<MovieDetail> updateMovieDetail(@PathVariable Long id, @RequestBody MovieDetail movieDetail) {
        Optional<MovieDetail> existingMovieDetail = movieDetailService.getMovieDetailById(id);
        if (existingMovieDetail.isPresent()) {
            return ResponseEntity.ok(movieDetailService.updateMovieDetail(id, movieDetail));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar detalle de película", description = "Elimina un detalle de película por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieDetail(@PathVariable Long id) {
        movieDetailService.deleteMovieDetail(id);
        return ResponseEntity.noContent().build();
    }
}
