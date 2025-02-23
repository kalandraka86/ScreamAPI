package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.MovieDetail;
import com.example.ProjectSpringBoot.repositories.MovieDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieDetailService {

    @Autowired
    private MovieDetailRepository movieDetailRepository;

    public List<MovieDetail> getAllMovieDetails() {
        return movieDetailRepository.findAll();
    }

    public Optional<MovieDetail> getMovieDetailById(Long id) {
        return movieDetailRepository.findById(id);
    }

    public MovieDetail createMovieDetail(MovieDetail movieDetail) {
        return movieDetailRepository.save(movieDetail);
    }

    public MovieDetail updateMovieDetail(Long id, MovieDetail movieDetail) {
        movieDetail.setId(id);
        return movieDetailRepository.save(movieDetail);
    }

    public void deleteMovieDetail(Long id) {
        movieDetailRepository.deleteById(id);
    }
}
