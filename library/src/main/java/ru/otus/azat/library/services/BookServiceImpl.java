package ru.otus.azat.library.services;

import org.springframework.stereotype.Service;
import ru.otus.azat.library.dao.AuthorDao;
import ru.otus.azat.library.dao.BookDao;
import ru.otus.azat.library.dao.GenreDao;
import ru.otus.azat.library.entities.Book;
import ru.otus.azat.library.exceptions.AuthorException;
import ru.otus.azat.library.exceptions.GenreException;

@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final GenreDao genreDao;
    private final AuthorDao authorDao;

    public BookServiceImpl(BookDao bookDao, GenreDao genreDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.genreDao = genreDao;
        this.authorDao = authorDao;
    }

    @Override
    public Book createNewBook(String title, String authorFullName, String genreName) {
        try {
            Book newBook = new Book();
            long newId = bookDao.count()+1;
            newBook.setId(newId);
            newBook.setTitle(title);
            newBook.setAuthor(authorDao.getByName(authorFullName));
            newBook.setGenre(genreDao.getByName(genreName));
            return newBook;
        }
        catch (AuthorException e){
            throw new AuthorException("We don't have that author", e);
        }
        catch (GenreException e){
            throw new GenreException("We don't have that genre", e);
        }
    }
}
