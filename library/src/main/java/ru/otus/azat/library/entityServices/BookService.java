package ru.otus.azat.library.entityServices;

import ru.otus.azat.library.entities.Book;

import java.util.List;

public interface BookService {
    Book createNewBook(String title, String authorFullName, String genreName);
    Book updateBook(long id, String value);
    void deleteBook(long id);
    Book findBook(long id);
    List<Book> findAllBooks();
}
