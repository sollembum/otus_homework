package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.Book;

public interface BookService {
    Book createNewBook(String title, String authorFullName, String genreName);
}
