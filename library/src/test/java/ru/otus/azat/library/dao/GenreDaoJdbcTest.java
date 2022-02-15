package ru.otus.azat.library.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.dao.GenreDaoJdbc;
import ru.otus.azat.library.entities.Genre;
import ru.otus.azat.library.exceptions.GenreException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(GenreDaoJdbc.class)
public class GenreDaoJdbcTest {
    @Autowired
    private GenreDaoJdbc dao;
    @Test
    public void getGenreByNameSuccess(){
        Genre actualGenre = new Genre(1L,"horror");
        Genre dbGenre = dao.getByName("horror");
        assertEquals(actualGenre, dbGenre);
    }
    @Test
    public void getGenreByNameFail(){
        assertThrows(GenreException.class, ()->{
            dao.getByName("nonGenre");
        });
    }
    @Test
    public void getAllGenresTest(){
        List<Genre> log = dao.getAll();
        assertNotNull(log);
        assertEquals(8, log.size());
    }
}
