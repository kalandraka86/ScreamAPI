package com.example.ProjectSpringBoot.controllers;

import com.example.ProjectSpringBoot.models.MovieDetail;
import com.example.ProjectSpringBoot.services.MovieDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie-details")
public class MovieDetailController {

    @Autowired
    private MovieDetailService movieDetailService;

    @GetMapping
    public List<MovieDetail> getAllMovieDetails() {
        return movieDetailService.getAllMovieDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetail> getMovieDetailById(@PathVariable Long id) {
        Optional<MovieDetail> movieDetail = movieDetailService.getMovieDetailById(id);
        return movieDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MovieDetail> createMovieDetail(@RequestBody MovieDetail movieDetail) {
        return new ResponseEntity<>(movieDetailService.createMovieDetail(movieDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDetail> updateMovieDetail(@PathVariable Long id, @RequestBody MovieDetail movieDetail) {
        return ResponseEntity.ok(movieDetailService.updateMovieDetail(id, movieDetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieDetail(@PathVariable Long id) {
        movieDetailService.deleteMovieDetail(id);
        return ResponseEntity.noContent().build();
    }
}
