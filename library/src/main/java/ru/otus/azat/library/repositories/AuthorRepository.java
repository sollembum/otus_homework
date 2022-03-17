package ru.otus.azat.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.azat.library.entities.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByFullName(String name);
    List<Author> findAll();
}
