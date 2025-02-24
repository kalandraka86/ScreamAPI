package com.example.ProjectSpringBoot.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del actor no puede estar vacío")
    @Size(min = 1, max = 255, message = "El nombre debe tener entre 1 y 255 caracteres")
    @Column(nullable = false)
    private String name;

    private LocalDate birthdate;  // Cambio a LocalDate

    public Actor() {}

    public Actor(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
