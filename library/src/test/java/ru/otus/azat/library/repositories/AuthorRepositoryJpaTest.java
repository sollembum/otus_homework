package ru.otus.azat.library.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.entities.Author;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(AuthorRepositoryJpa.class)
public class AuthorRepositoryJpaTest {
    private static final String DUMA = "duma";

    @Autowired
    private AuthorRepositoryJpa authorRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    void successFindAuthorByName(){
        Author expectedAuthor = authorRepository.getByName(DUMA);
        Author actualAuthor = em.find(Author.class, 1l);
        assertEquals(expectedAuthor, actualAuthor);
    }
    @Test
    void successFindAllAuthors(){
        List<Author> expectedAuthors = authorRepository.getAll();
        assertEquals(expectedAuthors.size(), 4);
    }
}
