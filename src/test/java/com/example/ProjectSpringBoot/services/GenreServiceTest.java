package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Genre;
import com.example.ProjectSpringBoot.repositories.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Usar @ExtendWith en lugar de @RunWith
class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;

    private Genre genre;

    @BeforeEach
    void setUp() {
        genre = new Genre("Action");
    }

    @Test
    void updateGenre() {
        genre.setName("Updated Genre");
        when(genreRepository.save(genre)).thenReturn(genre);  // Simulamos que el repositorio guarda y devuelve el género actualizado.

        Genre updatedGenre = genreService.updateGenre(1L, genre);  // Llamamos al método del servicio.

        assertNotNull(updatedGenre);  // Verificamos que el género no sea nulo.
        assertEquals("Updated Genre", updatedGenre.getName());  // Verificamos que el nombre del género haya sido actualizado.

        verify(genreRepository, times(1)).save(genre);  // Verificamos que el método save del repositorio haya sido llamado una vez.
    }
}
