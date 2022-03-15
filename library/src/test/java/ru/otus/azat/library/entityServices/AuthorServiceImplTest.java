package ru.otus.azat.library.entityServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.azat.library.exceptions.AuthorException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AuthorServiceImplTest {
    @Autowired
    private AuthorService authorService;

    @Test
    public void getAuthorFail(){
        assertThrows(AuthorException.class, () -> {
            authorService.getAuthor("notAuthor");
        });
    }
}