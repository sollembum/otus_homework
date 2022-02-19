package ru.otus.azat.library.services;

import ru.otus.azat.library.entities.Genre;

import java.util.List;

public interface GenreService {
    Genre getGenre(String name);

    List<Genre> getAllGenres();
}
