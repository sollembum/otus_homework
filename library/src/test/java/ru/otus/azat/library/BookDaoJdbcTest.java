package ru.otus.azat.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.azat.library.dao.AuthorDaoJdbc;
import ru.otus.azat.library.dao.BookDaoJdbc;
import ru.otus.azat.library.dao.GenreDaoJdbc;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.Genre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


@JdbcTest
@Import({BookDaoJdbc.class, GenreDaoJdbc.class, AuthorDaoJdbc.class})
public class BookDaoJdbcTest {
    @Autowired
    private BookDaoJdbc bookDao;
    @Autowired
    private GenreDaoJdbc genreDao;
    @Autowired
    private AuthorDaoJdbc authorDao;

    int EXPECTED_BOOKS = 2;
    @Test
    public void getAllBooksTest() {
        List<Book> lob = bookDao.getAll();
        assertNotNull(lob);
        assertEquals(EXPECTED_BOOKS, lob.size());
    }
    @Test
    public void createBookTest(){
        List<Genre> log = genreDao.getAll();

        List<Author> loa = authorDao.getAll();

        Book testBook = new Book (101L, "testbook", loa.get(0), log.get(0));
        bookDao.create(testBook);
        Book bookToFromDb = bookDao.getById(101L);
        assertNotNull(bookToFromDb);
        assertEquals(bookToFromDb, testBook);
        assertEquals(EXPECTED_BOOKS + 1,bookDao.getAll().size());
    }
    @Test
    public void getByIdTest() {
        Author author = new Author(1L, "duma");
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
        List<Book> lob = bookDao.getAll();
        assertEquals(EXPECTED_BOOKS-1, lob.size());
    }
    @Test
    public void updBookTest() {
        bookDao.updateById(1L,"testTitle");
        Book updatedBook = bookDao.getById(1L);
        assertEquals("testTitle", updatedBook.getTitle());
    }
}
