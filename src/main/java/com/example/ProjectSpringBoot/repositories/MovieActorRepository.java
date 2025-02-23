package com.example.ProjectSpringBoot.repositories;

import com.example.ProjectSpringBoot.models.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {
}
