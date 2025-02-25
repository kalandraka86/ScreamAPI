package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.Genre;
import com.example.ProjectSpringBoot.services.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
@Tag(name = "Genres", description = "Endpoints para gestionar los géneros de las películas")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Operation(summary = "Obtener todos los géneros", description = "Devuelve la lista completa de géneros")
    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @Operation(summary = "Obtener género por ID", description = "Devuelve un género específico por su ID")
    @GetMapping("/{id}")
    public Optional<Genre> getGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

    @Operation(summary = "Crear nuevo género", description = "Crea un nuevo género y lo guarda en la base de datos")
    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @Operation(summary = "Actualizar género", description = "Actualiza los detalles de un género existente")
    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        return genreService.updateGenre(id, genre);
    }

    @Operation(summary = "Eliminar género", description = "Elimina un género por su ID")
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}
