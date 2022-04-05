package ru.otus.azat.library.entityServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.exceptions.GenreException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataMongoTest
@Import(GenreServiceImpl.class)
public class GenreServiceImplTest {
    @Autowired
    private GenreServiceImpl genreService;

    @Test
    public void getGenreTestFail(){
        assertThrows(GenreException.class, () -> {
            genreService.getGenre("notGenre");
        });
    }
}