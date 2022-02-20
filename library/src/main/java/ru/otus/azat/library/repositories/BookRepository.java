package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book student);
    Optional<Book> findById(Long id);

    List<Book> findAll();
    List<Book> findByName(String name);

    void updateNameById(Long id, String name);
    void deleteById(Long id);
}
