package ru.otus.azat.library.dao;

import ru.otus.azat.library.entities.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAll();
}
