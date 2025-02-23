package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Actor;
import com.example.ProjectSpringBoot.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(Long id, Actor actor) {
        actor.setId(id);
        return actorRepository.save(actor);
    }

    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
