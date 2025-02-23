package com.example.ProjectSpringBoot.repositories;

import com.example.ProjectSpringBoot.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE LOWER(TRIM(m.genre.name)) LIKE LOWER(CONCAT('%', TRIM(:genreName), '%'))")
    List<Movie> findMoviesByGenreName(@Param("genreName") String genreName);

    @Query("SELECT m FROM Movie m WHERE LOWER(TRIM(m.director.nationality)) LIKE LOWER(CONCAT('%', TRIM(:countryName), '%'))")
    List<Movie> findMoviesByCountry(@Param("countryName") String countryName);

    // Consulta que busca el título sin importar mayúsculas/minúsculas y sin espacios
    @Query("SELECT m FROM Movie m WHERE REPLACE(LOWER(m.title), ' ', '') = :formattedTitle")
    Movie findByFormattedTitle(String formattedTitle);
}
