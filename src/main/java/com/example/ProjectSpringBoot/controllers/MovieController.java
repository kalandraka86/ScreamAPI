package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.Movie;
import com.example.ProjectSpringBoot.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Devuelve la lista de todas las películas
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Devuelve las películas por nombre de género
    @GetMapping("/genre/{genreName}")
    public List<Movie> getMoviesByGenreName(@PathVariable String genreName) {
        return movieService.getMoviesByGenreName(genreName);
    }

    @GetMapping("/country/{countryName}")
    public List<Movie> getMoviesByCountryName(@PathVariable String countryName) {
        return movieService.getMoviesByCountryName(countryName);
    }

    // Devuelve una película por su ID
    @GetMapping("/id/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }

    // Actualiza una película existente por su ID
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    // Elimina una película por su ID
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/{title}")
    public Movie getMovieByTitle(@PathVariable String title) {
        // Convertimos el título a minúsculas y eliminamos los espacios
        String formattedTitle = title.toLowerCase().replace(" ", "");
        return movieService.getMovieByTitle(formattedTitle);
    }

}
