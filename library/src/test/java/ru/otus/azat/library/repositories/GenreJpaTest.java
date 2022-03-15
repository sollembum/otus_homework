package ru.otus.azat.library.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.entities.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(GenreRepositoryJpa.class)
public class GenreJpaTest {
    private static final String HORROR = "horror";

    @Autowired
    private TestEntityManager em;
    @Autowired
    private GenreRepositoryJpa genreRepository;

    @Test
    void successFindGenreByName(){
        Genre expectedGenre = genreRepository.getByName(HORROR);
        Genre actualGenre = em.find(Genre.class, 1l);
        assertEquals(expectedGenre, actualGenre);
    }
    @Test
    void successFindAllGenres(){
        List<Genre> expectedGenres = genreRepository.getAll();
        assertEquals(expectedGenres.size(), 8);
    }
}
