package ru.otus.azat.library.entityServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.exceptions.AuthorException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataMongoTest
@Import(AuthorServiceImpl.class)
public class AuthorServiceImplTest {
    @Autowired
    private AuthorServiceImpl authorService;

    @Test
    public void getAuthorFail(){
        assertThrows(AuthorException.class, () -> {
            authorService.getAuthor("notAuthor");
        });
    }
}