package ru.otus.azat.library.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.azat.library.entities.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookRepositoryTest {
    public final static String TEST_TITLE = "TestTitle";
    @Autowired
    private TestEntityManager em;
    @Autowired
    private BookRepository bookDao;

    @Test
    void successUpdateTitle(){
        bookDao.updateTitleById(TEST_TITLE, 1L);
        Book book = em.find(Book.class, 1L);
        assertEquals(TEST_TITLE, book.getTitle());
    }
}
