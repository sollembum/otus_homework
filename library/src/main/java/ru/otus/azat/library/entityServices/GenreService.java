package ru.otus.azat.library.entityServices;

import ru.otus.azat.library.entities.Genre;

import java.util.List;

public interface GenreService {
    Genre getGenre(String name);

    List<Genre> getAllGenres();
}
