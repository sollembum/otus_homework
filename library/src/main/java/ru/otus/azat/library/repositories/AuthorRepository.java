package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.Author;

import java.util.List;

public interface AuthorRepository {
    Author getByName(String name);
    List<Author> getAll();
}
