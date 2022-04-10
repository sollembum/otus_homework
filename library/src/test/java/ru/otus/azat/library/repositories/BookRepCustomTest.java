package ru.otus.azat.library.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class BookRepCustomTest {
    public final static String TEST_TITLE = "TestTitle";

    @Autowired
    private BookRepository bookRepository;

    @Test
    void successUpdateTitle(){
        bookRepository.updateTitleById(bookRepository.findByTitle("3pigs").get().getId(), TEST_TITLE);
        assertEquals(TEST_TITLE, (bookRepository.findByTitle(TEST_TITLE).get().getTitle()));
    }
}