package ru.otus.azat.library.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.BookComment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import(BookCommentRepositoryJpa.class)
public class BookCommentJpaTest {
    @Autowired
    private BookCommentRepositoryJpa bookCommentRepository;
    @Autowired
    private TestEntityManager em;

    @Test
    void successFindAll(){
        List<BookComment> expectedBookComment = bookCommentRepository.findAll();
        assertEquals(expectedBookComment.size(), 2);
    }
    @Test
    void successFindById(){
        BookComment expectedComment = bookCommentRepository.findById(1l);
        BookComment actualComment = em.find(BookComment.class, 1l);
        assertEquals(expectedComment, actualComment);
    }

    @Test
    void successUpdateComment(){
        bookCommentRepository.updateCommentById(1l, "newTestComment");
        BookComment actual = em.find(BookComment.class ,1l);
        assertEquals("newTestComment", actual.getComment());
    }

    @Test
    void successDeleteById(){
        bookCommentRepository.deleteById(1l);
        List<BookComment> expectedBooks = em.getEntityManager().createQuery("select s from BookComment s",
                BookComment.class).getResultList();
        assertEquals(expectedBooks.size(), 1);
    }
}
