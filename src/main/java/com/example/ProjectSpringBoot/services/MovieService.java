package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Director;
import com.example.ProjectSpringBoot.models.Genre;
import com.example.ProjectSpringBoot.models.Movie;
import com.example.ProjectSpringBoot.repositories.DirectorRepository;
import com.example.ProjectSpringBoot.repositories.GenreRepository;
import com.example.ProjectSpringBoot.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private GenreRepository genreRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        if (movie.getDirector() == null || movie.getDirector().getId() == null) {
            throw new IllegalArgumentException("El director no puede ser nulo");
        }

        if (movie.getGenre() == null || movie.getGenre().getId() == null) {
            throw new IllegalArgumentException("El género no puede ser nulo");
        }

        // Buscar director por ID
        Director director = directorRepository.findById(movie.getDirector().getId())
                .orElseThrow(() -> new IllegalArgumentException("El director con ID " + movie.getDirector().getId() + " no existe"));

        // Buscar género por ID
        Genre genre = genreRepository.findById(movie.getGenre().getId())
                .orElseThrow(() -> new IllegalArgumentException("El género con ID " + movie.getGenre().getId() + " no existe"));

        // Asignar director y género a la película
        movie.setDirector(director);
        movie.setGenre(genre);

        return movieRepository.save(movie);
    }



    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> getMoviesByGenreName(String genreName) {
        // Buscar todas las películas asociadas al género por nombre
        return movieRepository.findMoviesByGenreName(genreName);
    }

    public List<Movie> getMoviesByCountryName(String countryName) {
        // Buscar todas las películas asociadas al género por nombre
        return movieRepository.findMoviesByCountry(countryName);
    }

    public Movie getMovieByTitle(String title) {
        // Convertimos el título a minúsculas y eliminamos los espacios antes de buscar
        String formattedTitle = title.toLowerCase().replace(" ", "");
        return movieRepository.findByFormattedTitle(formattedTitle);
    }
}
