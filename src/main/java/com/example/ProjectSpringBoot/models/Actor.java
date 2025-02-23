package com.example.ProjectSpringBoot.models;

import jakarta.persistence.*;
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

    @Size(max = 10, message = "La fecha de nacimiento no puede tener más de 10 caracteres")
    private String birthdate;

    public Actor() {}

    public Actor(String name, String birthdate) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
