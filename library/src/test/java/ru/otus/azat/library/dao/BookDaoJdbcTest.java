package ru.otus.azat.library.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@JdbcTest
@Import({BookDaoJdbc.class, GenreDaoJdbc.class, AuthorDaoJdbc.class})
public class BookDaoJdbcTest {

    public static final String TEST_AUTHOR = "duma";
    public static final String TEST_GENRE = "horror";
    public static final String TEST_TITLE = "testTitle";

    @Autowired
    private BookDaoJdbc bookDao;

    int EXPECTED_BOOKS = 2;

    @Test
    public void countBooksTest(){
        assertEquals(EXPECTED_BOOKS, bookDao.count());
    }

    @Test
    public void getAllBooksTest() {
        List<Book> lob = bookDao.getAll();
        assertNotNull(lob);
        assertEquals(EXPECTED_BOOKS, lob.size());
    }

    @Test
    public void createBookTest(){
        Author author = new Author(1L, TEST_AUTHOR);
        Genre genre = new Genre(1L, TEST_GENRE);
        Book testBook = new Book (3L, TEST_TITLE, author, genre);
        bookDao.create(testBook);
        Book bookToFromDb = bookDao.getById(3L);
        assertNotNull(bookToFromDb);
        assertEquals(testBook, bookToFromDb);
        assertEquals(EXPECTED_BOOKS + 1,bookDao.count());
    }

    @Test
    public void getByIdTest() {
        Author author = new Author(1L, TEST_AUTHOR);
        Genre genre = new Genre(5L, "adventure");
        Book book = bookDao.getById(1L);
        assertNotNull(book);
        assertEquals(1L, book.getId());
        assertEquals("3 musketeers", book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(genre, book.getGenre());
    }

    @Test
    public void deleteBookTest() {
        bookDao.deleteById(1L);
        assertEquals(EXPECTED_BOOKS-1, bookDao.count());
    }

    @Test
    public void updBookTest() {
        bookDao.updateById(1L,TEST_TITLE);
        Book updatedBook = bookDao.getById(1L);
        assertEquals(TEST_TITLE, updatedBook.getTitle());
    }
}
