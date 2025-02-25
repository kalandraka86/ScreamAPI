package com.example.ProjectSpringBoot.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/")
@Tag(name = "Main", description = "Endpoint para saludar")
public class Main {

    @Operation(summary = "Saludo en el Main", description = "Devuelve un String de saludo")
    @GetMapping
    public String mensaje() {

        return "Hola ScreamAPI 😱";
    }

}
