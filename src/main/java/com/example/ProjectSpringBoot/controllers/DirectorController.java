package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.Director;
import com.example.ProjectSpringBoot.services.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Directores", description = "Endpoints para gestionar los directores de las películas")
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @Operation(summary = "Obtener todos los directores", description = "Devuelve la lista completa de directores")
    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @Operation(summary = "Obtener director por ID", description = "Devuelve un director específico por su ID")
    @GetMapping("/{id}")
    public Optional<Director> getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    @Operation(summary = "Crear nuevo director", description = "Crea un nuevo director y lo guarda en la base de datos")
    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorService.createDirector(director);
    }

    @Operation(summary = "Actualizar director", description = "Actualiza los detalles de un director existente")
    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable Long id, @RequestBody Director director) {
        return directorService.updateDirector(id, director);
    }

    @Operation(summary = "Eliminar director", description = "Elimina un director por su ID")
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
    }
}
