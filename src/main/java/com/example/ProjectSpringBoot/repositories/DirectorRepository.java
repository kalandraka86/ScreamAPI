package com.example.ProjectSpringBoot.repositories;

import com.example.ProjectSpringBoot.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    // Agrega consultas personalizadas si es necesario
}