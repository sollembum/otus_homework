package ru.otus.azat.library.repositories;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class BookCommentRepCustomTest {
    public static final String TEST_COMMENT = "TestComment";

    @Autowired
    private BookCommentRepository commentRepository;

    @Test
    void successUpdateComment(){
        commentRepository.updateComment(commentRepository.findAll().get(0).getId(), TEST_COMMENT);
        assertEquals(TEST_COMMENT, commentRepository.findAll().get(0).getComment());
    }
}
