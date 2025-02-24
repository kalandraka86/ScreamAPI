CREATE DATABASE IF NOT EXISTS SCREAM_DB;
USE SCREAM_DB;

-- Eliminar tablas en orden para evitar conflictos por FK
DROP TABLE IF EXISTS movie_actors, movie_details, movies, actors, directors, genres;

-- Tabla de géneros
CREATE TABLE genres (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de directores
CREATE TABLE directors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    nationality VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de películas
CREATE TABLE movies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    director_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    synopsis TEXT,
    cover TEXT,
    FOREIGN KEY (director_id) REFERENCES directors(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE,
    INDEX idx_director (director_id),
    INDEX idx_genre (genre_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Detalles de películas
CREATE TABLE movie_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT NOT NULL UNIQUE,
    duration INT NOT NULL,
    language VARCHAR(50) NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    INDEX idx_movie (movie_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabla de actores
CREATE TABLE actors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthdate DATE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Relación de películas y actores
CREATE TABLE movie_actors (
    movie_id BIGINT NOT NULL,
    actor_id BIGINT NOT NULL,
    PRIMARY KEY (movie_id, actor_id),
    FOREIGN KEY (movie_id) REFERENCES movies(id) ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES actors(id) ON DELETE CASCADE,
    INDEX idx_movie_actor (movie_id, actor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insertar géneros
INSERT INTO genres (name) VALUES 
    ('Horror'), ('Psychological Horror'), ('Paranormal Horror'), 
    ('Zombie Horror'), ('Found Footage Horror'), ('Slasher'), ('Body Horror');

-- Insertar directores
INSERT INTO directors (name, nationality) VALUES
    ('John Carpenter', 'USA'), ('Wes Craven', 'USA'), ('Stanley Kubrick', 'USA'),
    ('George A. Romero', 'USA'), ('Jaume Balagueró', 'Spain'), ('Álex de la Iglesia', 'Spain'),
    ('Shimizu Takashi', 'Japan'), ('Hideo Nakata', 'Japan'), ('Kiyoshi Kurosawa', 'Japan'),
    ('Takashi Miike', 'Japan'), ('Dario Argento', 'Italy'), ('Guillermo del Toro', 'Mexico'),
    ('Kim Jee-woon', 'South Korea');

-- Insertar películas
INSERT INTO movies (title, year, director_id, genre_id, synopsis, cover) VALUES
    ('El Orfanato', 2007, 5, 3, 'A woman returns to an orphanage where she grew up, only to uncover dark secrets related to her missing son.', 'http://example.com/elfantano_cover.jpg'),
    ('Rec', 2007, 5, 5, 'A TV crew gets trapped in a quarantined building while documenting a strange infection outbreak.', 'http://example.com/rec_cover.jpg'),
    ('Los otros', 2001, 6, 1, 'A woman lives in a mansion with her two sick children, believing they are being haunted by ghosts.', 'http://example.com/losotros_cover.jpg'),
    ('Suspiria', 1977, 11, 3, 'A young girl enrolls in a dance academy that is haunted by supernatural forces.', 'http://example.com/suspiria_cover.jpg'),
    ('Cronos', 1993, 12, 1, 'An ancient device grants immortality but comes with a terrifying curse.', 'http://example.com/cronos_cover.jpg'),
    ('A Tale of Two Sisters', 2003, 13, 2, 'Two sisters return home from a mental institution and experience disturbing events.', 'http://example.com/taleoftwosisters_cover.jpg');

-- Insertar detalles de películas
INSERT INTO movie_details (movie_id, duration, language, description) VALUES
    (1, 105, 'Spanish', 'Laura regresa al orfanato donde creció con la intención de reabrirlo. Sin embargo, su hijo comienza a comportarse de manera extraña, revelando la oscura historia del lugar.'),
    (2, 78, 'Spanish', 'Un equipo de reporteros queda atrapado en un edificio en cuarentena mientras documentan un extraño brote de infección, solo para descubrir un horror aún mayor.'),
    (3, 101, 'English', 'Grace vive en una mansión con sus dos hijos fotosensibles, pero empieza a notar la presencia de seres invisibles. A medida que la verdad sale a la luz, la historia toma un giro aterrador.'),
    (4, 92, 'Italian', 'Una joven bailarina ingresa a una prestigiosa academia de danza, solo para descubrir que está gobernada por una misteriosa y oscura fuerza sobrenatural.'),
    (5, 94, 'Spanish', 'Un antiguo dispositivo con forma de escarabajo concede la inmortalidad a su portador, pero a un costo macabro que revela la lucha entre el bien y el mal.'),
    (6, 115, 'Korean', 'Dos hermanas regresan a casa después de estar en un hospital psiquiátrico, solo para encontrarse con eventos inquietantes y una madrastra con intenciones cuestionables.');

-- Insertar actores
INSERT INTO actors (name, birthdate) VALUES
    ('Belén Rueda', '1965-03-16'), ('Manuela Velasco', '1975-10-23'), 
    ('Nicole Kidman', '1967-06-20'), ('Jessica Harper', '1949-10-10'), 
    ('Federico Luppi', '1936-02-23'), ('Im Soo-jung', '1979-07-11');

-- Relación películas-actores
INSERT INTO movie_actors (movie_id, actor_id) VALUES
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6);
