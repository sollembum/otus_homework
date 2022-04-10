package ru.otus.azat.library.entityServices;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookService {
    Book createNewBook(String title, String authorFullName, String genreName);
    void updateBook(String id, String value);
    void deleteBook(String id);
    Book findBook(String id);
    List<Book> findAllBooks();
}
