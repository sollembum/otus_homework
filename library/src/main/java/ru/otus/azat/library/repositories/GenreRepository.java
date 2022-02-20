package ru.otus.azat.library.repositories;

import ru.otus.azat.library.entities.Genre;

import java.util.List;

public interface GenreRepository {
    Genre getByName(String name);

    List<Genre> getAll();
}
