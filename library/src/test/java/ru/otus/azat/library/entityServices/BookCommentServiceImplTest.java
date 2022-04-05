package ru.otus.azat.library.entityServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.repositories.BookCommentRepCustom;
import ru.otus.azat.library.repositories.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataMongoTest
@Import(BookCommentServiceImpl.class)
public class BookCommentServiceImplTest {
    @MockBean
    private BookService bookService;
    @MockBean
    private BookCommentRepCustom bookCommentRepCustom;
    @Autowired
    private BookCommentServiceImpl commentService;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void successSaveComment(){
        commentService.saveComment("newTestComment",bookRepository.findByTitle("3pigs").get().getId());
        assertEquals(2,commentService.findComments().size());
    }
}