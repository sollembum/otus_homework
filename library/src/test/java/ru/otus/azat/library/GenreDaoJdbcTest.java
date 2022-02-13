package ru.otus.azat.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.dao.GenreDaoJdbc;
import ru.otus.azat.library.entities.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JdbcTest
@Import(GenreDaoJdbc.class)
public class GenreDaoJdbcTest {
    @Autowired
    private GenreDaoJdbc dao;

    @Test
    public void getAllGenresTest(){
        List<Genre> log = dao.getAll();
        assertNotNull(log);
        assertEquals(8, log.size());
    }
}
