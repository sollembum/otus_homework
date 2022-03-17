package ru.otus.azat.library.entityServices;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class BookCommentServiceImplTest {

    @Autowired
    private BookCommentServiceImpl commentService;
    @Test
    void successSaveComment(){
        commentService.saveComment("newTestComment",2l);
        assertEquals(3,commentService.findCommentsByBook(2l).size());
    }
}
