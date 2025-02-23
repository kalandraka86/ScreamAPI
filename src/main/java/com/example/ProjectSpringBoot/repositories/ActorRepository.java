package com.example.ProjectSpringBoot.repositories;

import com.example.ProjectSpringBoot.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
