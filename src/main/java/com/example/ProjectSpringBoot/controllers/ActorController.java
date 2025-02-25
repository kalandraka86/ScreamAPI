package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.Actor;
import com.example.ProjectSpringBoot.services.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
@Tag(name = "Actores", description = "Endpoints para gestionar los actores de las películas")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @Operation(summary = "Obtener todos los actores", description = "Devuelve la lista completa de actores")
    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @Operation(summary = "Obtener actor por ID", description = "Devuelve un actor específico por su ID")
    @ApiResponse(responseCode = "200", description = "Actor encontrado")
    @ApiResponse(responseCode = "404", description = "Actor no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Optional<Actor> actor = actorService.getActorById(id);
        return actor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear nuevo actor", description = "Crea un nuevo actor y lo guarda en la base de datos")
    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        return new ResponseEntity<>(actorService.createActor(actor), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar actor", description = "Actualiza los detalles de un actor existente")
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody Actor actor) {
        return ResponseEntity.ok(actorService.updateActor(id, actor));
    }

    @Operation(summary = "Eliminar actor", description = "Elimina un actor por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
        return ResponseEntity.noContent().build();
    }
}
