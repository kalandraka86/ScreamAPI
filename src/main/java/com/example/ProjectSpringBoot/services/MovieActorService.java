package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.MovieActor;
import com.example.ProjectSpringBoot.repositories.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieActorService {

    @Autowired
    private MovieActorRepository movieActorRepository;

    public List<MovieActor> getAllMovieActors() {
        return movieActorRepository.findAll();
    }

    public MovieActor createMovieActor(MovieActor movieActor) {
        return movieActorRepository.save(movieActor);
    }

    public void deleteMovieActor(Long movieId, Long actorId) {
        movieActorRepository.deleteById(movieId);
    }
}
