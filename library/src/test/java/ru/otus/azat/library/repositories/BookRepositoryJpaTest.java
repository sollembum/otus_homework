package ru.otus.azat.library.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.entities.Book;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@DataJpaTest
@Import(BookRepositoryJpa.class)
public class BookRepositoryJpaTest {
    private static final String TEST_NAME = "evgeniy onegin";

    @Autowired
    private BookRepositoryJpa bookRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    void successUpdateByid(){
        bookRepository.updateNameById(1l, "newTestTitle");
        Book fromdb = em.find(Book.class, 1l);
        assertEquals(fromdb.getTitle(), "newTestTitle");
    }



    @Test
    void successFindAllBooks(){
        List<Book> expectedBooks = bookRepository.findAll();
        assertEquals(expectedBooks.size(), 2);
    }
    @Test
    void successFindBookById(){
        Book expectedBook = bookRepository.findById(1l);
        Book actualBook = em.find(Book.class, 1l);
        assertEquals(expectedBook, actualBook);
    }

    @Test
    void successDeleteById(){
        bookRepository.deleteById(1l);
        List<Book> expectedBooks = em.getEntityManager().createQuery("select s from Book s",
                Book.class).getResultList();
        assertEquals(expectedBooks.size(), 1);
    }
}
