package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookService {
    Book createNewBook(String title, String authorFullName, String genreName);
    String updateBook(Long id, String value);
    String deleteBook(Long id);
    Book findBook(Long id);
    List<Book> findAllBooks();

    int countBooks();
}
