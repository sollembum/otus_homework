package ru.otus.azat.library.repositories;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.azat.library.entities.BookComment;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BookCommentRepositoryTest {
    public static final String TEST_COMMENT = "TestComment";
    @Autowired
    private TestEntityManager em;
    @Autowired
    private BookCommentRepository commentDao;

    @Test
    void successUpdateComment(){
        commentDao.updateBookCommentById(TEST_COMMENT, 1L);
        BookComment bookComment = em.find(BookComment.class, 1L);
        assertEquals(TEST_COMMENT, bookComment.getComment());
    }
}
