package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createNewBook(String title, String authorFullName, String genreName);
    void updateBook(Long id, String value);
    void deleteBook(Long id);
    Optional<Book> findBook(Long id);
    List<Book> findAllBooks();

    int countBooks();
}
