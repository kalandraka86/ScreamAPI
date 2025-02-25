package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.Movie;
import com.example.ProjectSpringBoot.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@Tag(name = "Películas", description = "Endpoints para gestionar películas de terror")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Devuelve la lista de todas las películas
    @GetMapping
    @Operation(
            summary = "Obtener todas las películas",
            description = "Devuelve una lista de todas las películas disponibles.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de películas recuperada exitosamente")
            }
    )
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Devuelve las películas por nombre de género
    @GetMapping("/genre/{genreName}")
    @Operation(
            summary = "Obtener películas por género",
            description = "Devuelve una lista de películas que pertenecen al género especificado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Películas del género encontradas"),
                    @ApiResponse(responseCode = "404", description = "No se encontraron películas para el género especificado")
            }
    )
    public List<Movie> getMoviesByGenreName(
            @Parameter(description = "Nombre del género") @PathVariable String genreName) {
        return movieService.getMoviesByGenreName(genreName);
    }

    // Devuelve las películas por país
    @GetMapping("/country/{countryName}")
    @Operation(
            summary = "Obtener películas por país",
            description = "Devuelve una lista de películas que pertenecen al país especificado.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Películas del país encontradas"),
                    @ApiResponse(responseCode = "404", description = "No se encontraron películas para el país especificado")
            }
    )
    public List<Movie> getMoviesByCountryName(
            @Parameter(description = "Nombre del país") @PathVariable String countryName) {
        return movieService.getMoviesByCountryName(countryName);
    }

    // Devuelve una película por su ID
    @GetMapping("/id/{id}")
    @Operation(
            summary = "Obtener una película por ID",
            description = "Busca una película por su identificador único (ID).",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película encontrada"),
                    @ApiResponse(responseCode = "404", description = "Película no encontrada")
            }
    )
    public Optional<Movie> getMovieById(
            @Parameter(description = "ID de la película") @PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    // Crear una nueva película
    @PostMapping("/newMovie")
    @Operation(
            summary = "Crear una nueva película",
            description = "Añade una nueva película a la base de datos.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película creada exitosamente"),
                    @ApiResponse(responseCode = "400", description = "Error en la creación de la película")
            }
    )
    public ResponseEntity<Movie> createMovie(
            @Parameter(description = "Detalles de la película a crear") @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }

    // Actualizar una película existente por su ID
    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar una película",
            description = "Actualiza los detalles de una película existente por su ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película actualizada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Película no encontrada")
            }
    )
    public Movie updateMovie(
            @Parameter(description = "ID de la película a actualizar") @PathVariable Long id,
            @Parameter(description = "Detalles actualizados de la película") @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    // Eliminar una película por su ID
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar una película",
            description = "Elimina una película de la base de datos por su ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Película eliminada exitosamente"),
                    @ApiResponse(responseCode = "404", description = "Película no encontrada")
            }
    )
    public void deleteMovie(
            @Parameter(description = "ID de la película a eliminar") @PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    // Obtener película por título (formateado)
    @GetMapping("/title/{title}")
    @Operation(
            summary = "Buscar película por título",
            description = "Busca una película por su título (ignorando mayúsculas y espacios).",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película encontrada"),
                    @ApiResponse(responseCode = "404", description = "Película no encontrada")
            }
    )
    public Movie getMovieByTitle(
            @Parameter(description = "Título de la película") @PathVariable String title) {
        String formattedTitle = title.toLowerCase().replace(" ", "");
        return movieService.getMovieByTitle(formattedTitle);
    }
}
