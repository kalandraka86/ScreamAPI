package com.example.ProjectSpringBoot.services;

import com.example.ProjectSpringBoot.models.Actor;
import com.example.ProjectSpringBoot.repositories.ActorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ActorServiceTest {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorService actorService;

    private Actor actor;

    @BeforeEach
    void setUp() {
        // Usamos LocalDate para la fecha de nacimiento
        actor = new Actor("Robert Downey Jr.", LocalDate.of(1975, 3, 23));  // Usamos LocalDate
    }

    @Test
    void createActor() {
        when(actorRepository.save(actor)).thenReturn(actor);  // Simulamos que el repositorio devuelve el mismo actor.

        Actor createdActor = actorService.createActor(actor);  // Llamamos al método del servicio.

        assertNotNull(createdActor);  // Verificamos que el actor no sea nulo.
        assertEquals("Robert Downey Jr.", createdActor.getName());  // Verificamos que el nombre del actor sea el esperado.

        verify(actorRepository, times(1)).save(actor);  // Verificamos que el método save del repositorio haya sido llamado una vez.
    }
}
