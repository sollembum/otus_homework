package ru.otus.azat.library.entityServices;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceImplTest {
    public static final Long WRONG_ID = 9L;
    public static final String TEST_AUTHOR = "duma";
    public static final String TEST_GENRE = "horror";
    public static final String TEST_TITLE = "testTitle";
    /*@Autowired
    private BookService bookService;
   /* @Autowired
    private BookDaoJdbc bookDao;

    @Test
    public void createNewBookTestSuccess(){
        Author author = new Author(1L, TEST_AUTHOR);
        Genre genre = new Genre(1L, TEST_GENRE);
        Book testBook = new Book();
        bookService.createNewBook(TEST_TITLE, TEST_AUTHOR, TEST_GENRE);
        assertEquals(testBook, bookDao.getById(3L));
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
    public void updateBookTestFail(){
        assertEquals("We don't have that book id", bookService.updateBook(WRONG_ID,TEST_TITLE));
    }

    @Test
    public void deleteBookTest(){
        assertEquals("That book was deleted", bookService.deleteBook(1L));
        assertEquals("We don't have that book id", bookService.deleteBook(1L));
    }
    @Test
    public void findBookFail(){
        assertThrows(BookException.class, () -> {
            bookService.findBook(WRONG_ID);
        });
    }*/
}