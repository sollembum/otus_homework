package ru.otus.azat.library.entityServices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.azat.library.exceptions.GenreException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class GenreServiceImplTest {
    @Autowired
    private GenreService genreService;

    @Test
    public void getGenreTestFail(){
        assertThrows(GenreException.class, () -> {
            genreService.getGenre("notGenre");
        });
    }
}
