package ru.otus.azat.library.entityServices;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.Genre;
import ru.otus.azat.library.exceptions.AuthorException;
import ru.otus.azat.library.exceptions.BookException;
import ru.otus.azat.library.exceptions.GenreException;
import ru.otus.azat.library.repositories.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceImplTest {
    public static final Long WRONG_ID = 99L;
    public static final String TEST_AUTHOR = "duma";
    public static final String TEST_GENRE = "horror";
    public static final String TEST_TITLE = "testTitle";
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookDao;

    @Test
    public void createNewBookTestSuccess(){
        Author author = new Author(1L, TEST_AUTHOR);
        Genre genre = new Genre(1L, TEST_GENRE);
        Book testBook = new Book(3L, TEST_TITLE, author, genre);
        bookService.createNewBook(TEST_TITLE, TEST_AUTHOR, TEST_GENRE);
        assertEquals(testBook, bookDao.findBookById(3l).get());
    }
    @Test
    public void createNewBookTestFailOnAuthor(){
        assertThrows(AuthorException.class, () -> {
            bookService.createNewBook(TEST_TITLE, TEST_AUTHOR+"FAIL", TEST_GENRE);
        });
    }

    @Test
    public void createNewBookTestFailOnGenre(){
        assertThrows(GenreException.class, () -> {
            bookService.createNewBook(TEST_TITLE, TEST_AUTHOR, TEST_GENRE+"FAIL");
        });
    }

    @Test
    public void findBookFail(){
        assertThrows(BookException.class, () -> {
            bookService.findBook(WRONG_ID);
        });
    }
}