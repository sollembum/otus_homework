package ru.otus.azat.library.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.azat.library.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, String>, BookRepCustom {
    List<Book> findAll();
    Optional<Book> findBookById(String id);
    Optional<Book> findByTitle(String title);
}
