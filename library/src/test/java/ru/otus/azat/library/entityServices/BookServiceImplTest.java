package ru.otus.azat.library.entityServices;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Genre;
import ru.otus.azat.library.exceptions.BookException;
import ru.otus.azat.library.repositories.BookRepCustom;
import ru.otus.azat.library.repositories.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@DataMongoTest
@Import(BookServiceImpl.class)
public class BookServiceImplTest {
    public static final Long WRONG_ID = 99L;
    public static final String TEST_AUTHOR = "Pushkin";
    public static final String TEST_GENRE = "horror";
    public static final String TEST_TITLE = "testTitle";
    @MockBean
    private GenreService genreService;
    @MockBean
    private AuthorService authorService;
    @MockBean
    private BookRepCustom bookRepCustom;
    @Autowired
    private BookService bookService;

    @Test
    public void createNewBookTestSuccess(){
        int startAmount = bookService.findAllBooks().size();
        Author author = new Author(TEST_AUTHOR);
        Genre genre = new Genre(TEST_GENRE);
        when(genreService.getGenre(TEST_GENRE)).thenReturn(genre);
        when(authorService.getAuthor(TEST_AUTHOR)).thenReturn(author);
        bookService.createNewBook(TEST_TITLE, TEST_AUTHOR, TEST_GENRE);
        assertEquals(startAmount + 1, bookService.findAllBooks().size());
    }

    @Test
    public void findBookFail(){
        assertThrows(BookException.class, () -> {
            bookService.findBook("WRONG_ID");
        });
    }
}