package ru.otus.azat.library.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.azat.library.entities.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, String> {
    Optional<Genre> findByName(String name);
    List<Genre> findAll();
}
