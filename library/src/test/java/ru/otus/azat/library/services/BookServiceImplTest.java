package ru.otus.azat.library.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.azat.library.dao.AuthorDaoJdbc;
import ru.otus.azat.library.dao.BookDaoJdbc;
import ru.otus.azat.library.dao.GenreDaoJdbc;
import ru.otus.azat.library.entities.Author;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.entities.Genre;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookServiceImplTest {
    public static final String TEST_AUTHOR = "duma";
    public static final String TEST_GENRE = "horror";
    public static final String TEST_TITLE = "testTitle";
    @Autowired
    private BookService bookService;
    @MockBean
    private BookDaoJdbc bookDao;
    @MockBean
    private GenreDaoJdbc genreDao;
    @MockBean
    private AuthorDaoJdbc authorDao;

    @Test
    public void createNewBookTestSuccess(){
        Author author = new Author(1L, TEST_AUTHOR);
        Genre genre = new Genre(1L, TEST_GENRE);
        Book testBook = new Book(101L, TEST_TITLE, author, genre);

        when(bookDao.count()).thenReturn(100);
        when(genreDao.getByName(genre.getName())).thenReturn(genre);
        when(authorDao.getByName(author.getFullName())).thenReturn(author);

        assertEquals(bookService.createNewBook(TEST_TITLE, author.getFullName(), genre.getName()), testBook);
    }
}
