package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.Director;
import com.example.ProjectSpringBoot.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    // Devuelve la lista de todos los directores
    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    // Devuelve un director por su ID
    @GetMapping("/{id}")
    public Optional<Director> getDirectorById(@PathVariable Long id) {
        return directorService.getDirectorById(id);
    }

    // Crea un nuevo director
    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorService.createDirector(director);
    }

    // Actualiza un director existente por su ID
    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable Long id, @RequestBody Director director) {
        return directorService.updateDirector(id, director);
    }

    // Elimina un director por su ID
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
    }
}