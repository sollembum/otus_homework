package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthor(String fullname);

    List<Author> getAllAuthors();
}
