package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Director;
import com.example.ProjectSpringBoot.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> getAllDirectors(){
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director updateDirector(Long id, Director director) {
        director.setId(id);
        return directorRepository.save(director);
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
