package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Director;
import com.example.ProjectSpringBoot.repositories.DirectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // Usar @ExtendWith en lugar de @RunWith
class DirectorServiceTest {

    @Mock
    private DirectorRepository directorRepository;

    @InjectMocks
    private DirectorService directorService;

    private Director director;

    @BeforeEach
    void setUp() {
        director = new Director("Christopher Nolan", "USA");
    }

    @Test
    void getDirectorById() {
        when(directorRepository.findById(1L)).thenReturn(Optional.of(director));  // Simulamos que el repositorio devuelve un director con id 1.

        Optional<Director> result = directorService.getDirectorById(1L);  // Llamamos al método del servicio.

        assertTrue(result.isPresent());  // Verificamos que el resultado esté presente.
        assertEquals("Christopher Nolan", result.get().getName());  // Verificamos que el nombre del director sea el esperado.

        verify(directorRepository, times(1)).findById(1L);  // Verificamos que el método findById haya sido llamado una vez.
    }
}
