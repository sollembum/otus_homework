package ru.otus.azat.library.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.dao.AuthorDaoJdbc;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.exceptions.AuthorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTest {
    @Autowired
    private AuthorDaoJdbc dao;
    @Test
    public void getAuthorByNameSuccess(){
        Author actualAuthor = new Author(1L,"duma");
        Author dbAuthor = dao.getByName("duma");
        assertEquals(actualAuthor, dbAuthor);
    }
    @Test
    public void getAuthorByNameFail(){
        assertThrows(AuthorException.class, ()->{
            dao.getByName("nonAuthor");
        });
    }
    @Test
    public void getAllAuthorsTest(){
        List<Author> loa = dao.getAll();
        assertNotNull(loa);
        assertEquals(4, loa.size());
    }
}
