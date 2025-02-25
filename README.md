# SCREAM API - Documentación del Proyecto

## Descripción
SCREAM API es un servicio RESTful desarrollado con Spring Boot que proporciona acceso y gestión de una base de datos de películas de terror. Esta API permite consultar, crear, actualizar y eliminar información sobre películas, directores, actores y géneros.

## Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3.2.3**
- **Spring Data JPA**: Para la persistencia de datos
- **MySQL**: Sistema de gestión de base de datos
- **Hibernate**: Como ORM (Object-Relational Mapping)
- **Maven**: Gestión de dependencias y construcción del proyecto
- **Springdoc OpenAPI**: Generación automática de documentación de la API
- **Spring Validation**: Validación de datos de entrada

## Estructura de la Base de Datos

La base de datos llamada `SCREAM_DB` contiene las siguientes tablas:

### Tablas Principales
- **genres**: Almacena los géneros de películas de terror
- **directors**: Información sobre directores de cine
- **movies**: Datos principales de las películas
- **movie_details**: Información adicional de cada película
- **actors**: Datos de actores
- **movie_actors**: Tabla de relación muchos a muchos entre películas y actores

### Diagrama de Relaciones

```
genres <---- movies ----> directors
              |
              |
              v
      movie_details
              |
              |
              v
 actors <--- movie_actors
```

## Endpoints API

### Actores (Actors)
```
BASE URL: /actors
```

| Método | Endpoint | Descripción | Códigos de Respuesta |
|--------|----------|-------------|----------------------|
| GET    | /        | Obtiene todos los actores | 200 - OK |
| GET    | /{id}    | Obtiene un actor por ID | 200 - OK, 404 - Not Found |
| POST   | /        | Crea un nuevo actor | 201 - Created |
| PUT    | /{id}    | Actualiza un actor existente | 200 - OK |
| DELETE | /{id}    | Elimina un actor | 204 - No Content |

### Directores (Directors)
```
BASE URL: /directors
```

| Método | Endpoint | Descripción | Códigos de Respuesta |
|--------|----------|-------------|----------------------|
| GET    | /        | Obtiene todos los directores | 200 - OK |
| GET    | /{id}    | Obtiene un director por ID | 200 - OK, 404 - Not Found |
| POST   | /        | Crea un nuevo director | 201 - Created |
| PUT    | /{id}    | Actualiza un director existente | 200 - OK |
| DELETE | /{id}    | Elimina un director | 204 - No Content |

### Géneros (Genres)
```
BASE URL: /genres
```

| Método | Endpoint | Descripción | Códigos de Respuesta |
|--------|----------|-------------|----------------------|
| GET    | /        | Obtiene todos los géneros | 200 - OK |
| GET    | /{id}    | Obtiene un género por ID | 200 - OK, 404 - Not Found |
| POST   | /        | Crea un nuevo género | 201 - Created |
| PUT    | /{id}    | Actualiza un género existente | 200 - OK |
| DELETE | /{id}    | Elimina un género | 204 - No Content |

### Películas (Movies)
```
BASE URL: /movies
```

| Método | Endpoint | Descripción | Códigos de Respuesta |
|--------|----------|-------------|----------------------|
| GET    | /        | Obtiene todas las películas | 200 - OK |
| GET    | /{id}    | Obtiene una película por ID | 200 - OK, 404 - Not Found |
| POST   | /        | Crea una nueva película | 201 - Created |
| PUT    | /{id}    | Actualiza una película existente | 200 - OK |
| DELETE | /{id}    | Elimina una película | 204 - No Content |

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── ProjectSpringBoot/
│   │               ├── controllers/
│   │               │   ├── ActorController.java
│   │               │   ├── DirectorController.java
│   │               │   ├── GenreController.java
│   │               │   └── MovieController.java
│   │               ├── models/
│   │               │   ├── Actor.java
│   │               │   ├── Director.java
│   │               │   ├── Genre.java
│   │               │   ├── Movie.java
│   │               │   └── MovieDetails.java
│   │               ├── repositories/
│   │               │   ├── ActorRepository.java
│   │               │   ├── DirectorRepository.java
│   │               │   ├── GenreRepository.java
│   │               │   └── MovieRepository.java
│   │               ├── services/
│   │               │   ├── ActorService.java
│   │               │   ├── DirectorService.java
│   │               │   ├── GenreService.java
│   │               │   └── MovieService.java
│   │               └── ProjectSpringBootApplication.java
│   └── resources/
│       ├── application.properties
│       └── db/
│           └── schema.sql
└── test/
    └── java/
        └── com/
            └── example/
                └── ProjectSpringBoot/
                    └── controllers/
                        ├── ActorControllerTest.java
                        └── ...
```

## Configuración y Ejecución

### Requisitos Previos
- JDK 21 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior

### Configuración del Entorno

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/scream-api.git
   cd scream-api
   ```

2. **Configurar la base de datos**

   Ejecutar el script SQL para crear la base de datos y las tablas:
   ```bash
   mysql -u root -p < src/main/resources/db/schema.sql
   ```

3. **Configurar application.properties**

   ```properties
   # Conexión a la base de datos
   spring.datasource.url=jdbc:mysql://localhost:3306/SCREAM_DB
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   
   # Configuración de JPA
   spring.jpa.hibernate.ddl-auto=validate
   spring.jpa.show-sql=true
   
   # Configuración del servidor
   server.port=8080
   
   # Configuración de OpenAPI/Swagger
   springdoc.api-docs.path=/api-docs
   springdoc.swagger-ui.path=/swagger-ui.html
   ```

4. **Construir y ejecutar la aplicación**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

### Acceso a la Documentación API
Una vez en ejecución, puedes acceder a la documentación interactiva de la API en:
- URL: `http://localhost:8080/swagger-ui.html`

## Ejemplos de Uso

### Consultar todos los actores
```bash
curl -X GET http://localhost:8080/actors
```

### Obtener un actor por ID
```bash
curl -X GET http://localhost:8080/actors/1
```

### Crear un nuevo actor
```bash
curl -X POST http://localhost:8080/actors \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Sigourney Weaver",
    "birthdate": "1949-10-08"
  }'
```

### Actualizar información de un actor
```bash
curl -X PUT http://localhost:8080/actors/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Belén Rueda",
    "birthdate": "1965-03-16"
  }'
```

### Eliminar un actor
```bash
curl -X DELETE http://localhost:8080/actors/1
```

## Ejemplos de Modelos de Datos

### Actor (Actor)
```json
{
  "id": 1,
  "name": "Belén Rueda",
  "birthdate": "1965-03-16"
}
```

### Director (Director)
```json
{
  "id": 5,
  "name": "Jaume Balagueró",
  "nationality": "Spain"
}
```

### Género (Genre)
```json
{
  "id": 3,
  "name": "Paranormal Horror"
}
```

### Película (Movie)
```json
{
  "id": 1,
  "title": "El Orfanato",
  "year": 2007,
  "director": {
    "id": 5,
    "name": "Jaume Balagueró",
    "nationality": "Spain"
  },
  "genre": {
    "id": 3,
    "name": "Paranormal Horror"
  },
  "synopsis": "A woman returns to an orphanage where she grew up, only to uncover dark secrets related to her missing son.",
  "cover": "http://example.com/elfantano_cover.jpg",
  "details": {
    "id": 1,
    "duration": 105,
    "language": "Spanish",
    "description": "Laura regresa al orfanato donde creció con la intención de reabrirlo. Sin embargo, su hijo comienza a comportarse de manera extraña, revelando la oscura historia del lugar."
  },
  "actors": [
    {
      "id": 1,
      "name": "Belén Rueda",
      "birthdate": "1965-03-16"
    }
  ]
}
```

## Documentación con OpenAPI/Swagger

La API utiliza anotaciones de OpenAPI para documentar cada endpoint:

```java
@RestController
@RequestMapping("/actors")
@Tag(name = "Actores", description = "Endpoints para gestionar los actores de las películas")
public class ActorController {

    @Operation(summary = "Obtener todos los actores", description = "Devuelve la lista completa de actores")
    @GetMapping
    public List<Actor> getAllActors() {
        // Implementación
    }

    @Operation(summary = "Obtener actor por ID", description = "Devuelve un actor específico por su ID")
    @ApiResponse(responseCode = "200", description = "Actor encontrado")
    @ApiResponse(responseCode = "404", description = "Actor no encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        // Implementación
    }
    
    // Otros métodos...
}
```

## Contribución
Si deseas contribuir a este proyecto, por favor:

1. Haz un fork del repositorio
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`)
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva característica'`)
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

## Licencia
Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.