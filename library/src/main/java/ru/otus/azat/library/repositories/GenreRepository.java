package ru.otus.azat.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.azat.library.entities.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findByName(String name);
    List<Genre> findAll();
}
