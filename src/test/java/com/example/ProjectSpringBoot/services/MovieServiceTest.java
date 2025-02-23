package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Movie;
import com.example.ProjectSpringBoot.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)  // Usar @ExtendWith en lugar de @RunWith
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;  // Mockea el repositorio

    @InjectMocks
    private MovieService movieService;  // La clase de servicio a probar

    @Test
    public void testGetAllMovies() {
        // Prepara el comportamiento del mock
        Movie movie = new Movie();
        movie.setTitle("Suspiria");
        List<Movie> mockedMovies = Arrays.asList(movie);

        when(movieRepository.findAll()).thenReturn(mockedMovies);  // Cuando se llame a findAll, se devuelve la lista mockeada

        // Llama al método del servicio
        List<Movie> movies = movieService.getAllMovies();

        // Realiza la aserción
        assertNotNull(movies);
        assertEquals(1, movies.size());
        assertEquals("Suspiria", movies.get(0).getTitle());

        // Verifica que se haya llamado al repositorio
        verify(movieRepository, times(1)).findAll();
    }
}
