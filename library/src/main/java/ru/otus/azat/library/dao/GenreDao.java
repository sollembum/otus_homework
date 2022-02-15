package ru.otus.azat.library.dao;

import ru.otus.azat.library.entities.Genre;

import java.util.List;

public interface GenreDao {
    Genre getByName(String name);

    List<Genre> getAll();
}
