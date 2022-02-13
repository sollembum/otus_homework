package ru.otus.azat.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.dao.AuthorDao;
import ru.otus.azat.library.dao.AuthorDaoJdbc;
import ru.otus.azat.library.entities.Author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTest {
    @Autowired
    private AuthorDaoJdbc dao;

    @Test
    public void getAllAuthorsTest(){
        List<Author> loa = dao.getAll();
        assertNotNull(loa);
        assertEquals(4, loa.size());
    }
}
