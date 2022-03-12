package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book student);
    Book findById(long id);

    List<Book> findAll();
    List<Book> findByName(String name);

    Book updateNameById(long id, String name);
    void deleteById(long id);
}
